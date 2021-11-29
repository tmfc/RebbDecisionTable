package tech.rebb.dt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecisionTable {

    private final Object obj;

    public Object getObj() {
        return obj;
    }

    private boolean evaluated;

    private boolean has_error;

    public boolean hasError() {
        return has_error;
    }

    private final List<String> errors;

    public List<String> getErrors() {
        return errors;
    }

    private final String name;

    public String getName() {
        return name;
    }

    private HitPolicy hitPolicy;

    public HitPolicy getHitPolicy() {
        return hitPolicy;
    }

    public void setHitPolicy(HitPolicy hitPolicy) {
        this.hitPolicy = hitPolicy;
    }

    private BuildInAggregation aggregation;

    public BuildInAggregation getAggregation() {
        return aggregation;
    }

    public void setAggregation(BuildInAggregation aggregation) {
        this.aggregation = aggregation;
    }

    private List<DecisionRuleInputClause> inputClauses;

    public List<DecisionRuleInputClause> getInputClauses() {
        return inputClauses;
    }

    private List<DecisionRuleOutputClause> outputClauses;

    public List<DecisionRuleOutputClause> getOutputClauses() {
        return outputClauses;
    }

    private List<DecisionRuleAnnotationClause> annotationClauses;

    public List<DecisionRuleAnnotationClause> getAnnotationClauses() {
        return annotationClauses;
    }

    private List<DecisionRule> rules;

    public List<DecisionRule> getRules() {
        return rules;
    }

    private String outputLabel;

    public String getOutputLabel() {
        return outputLabel;
    }

    public void setOutputLabel(String outputLabel) {
        this.outputLabel = outputLabel;
    }

    private String annotationLabel;

    public String getAnnotationLabel() {
        return annotationLabel;
    }

    public void setAnnotationLabel(String annotationLabel) {
        this.annotationLabel = annotationLabel;
    }

    public DecisionTable(String name, Object obj, HitPolicy hitPolicy, BuildInAggregation aggregation) {
        this.name = name;
        this.obj = obj;
        this.hitPolicy = hitPolicy;
        this.aggregation = aggregation;

        this.errors = new ArrayList<>();
        this.evaluated = false;

        this.outputLabel = "Result";
        this.annotationLabel = "Annotation";
    }

    public DecisionTable(String name, Object obj)
    {
        this(name, obj, HitPolicy.UNIQUE, BuildInAggregation.NA);
    }

    public boolean addRule(DecisionRule rule)
    {
        if(rule == null)
            return false;

        if(this.rules == null)
            this.rules = new ArrayList<>();

        for (DecisionRule r:
                this.rules) {
            // Check duplicated rule
            if(r.getSignature().equals(rule.getSignature()))
                return false;
        }

        this.rules.add(rule);

        // get output clause list
        if(this.outputClauses == null)
            this.outputClauses = new ArrayList<>();
        if(this.outputClauses.size() == 0)
        {
            for (DecisionRuleOutputEntry outputEntry :
                    rule.getOutput().getEntries()) {
                this.outputClauses.add(outputEntry.getClause());
            }
        }

        // get annotation clause list
        if(rule.getAnnotation() != null)
        {
            if(this.annotationClauses == null)
                this.annotationClauses = new ArrayList<>();
            if(this.annotationClauses.size() == 0)
            {
                for (DecisionRuleAnnotationEntry annotationEntry :
                        rule.getAnnotation().getEntries()) {
                    this.annotationClauses.add(annotationEntry.getClause());
                }
            }
        }

        return true;
    }

    public void run()
    {
        if(!this.checkRules())
        {
            this.has_error = true;
            return;
        }
        // sort rules
        this.sortRules();

        List<DecisionRule> matchedRules = new ArrayList<>();

        // evaluate rules
        for (DecisionRule rule :
                this.rules) {
            rule.setObj(this.obj);
            boolean result = false;
            try {
                result = rule.evaluate();
            } catch (RebbDTException e) {
//                e.printStackTrace();
               //TODO: handle exception
            }

            // rule does not match
            if(!result)
                continue;

            // if hit policy is first or priority, means no more rule need to be evaluated
            if(this.hitPolicy == HitPolicy.FIRST || this.hitPolicy == HitPolicy.PRIORITY)
            {
                break;
            }
            else if(this.hitPolicy == HitPolicy.UNIQUE)
            {
                matchedRules.add(rule);
                if(matchedRules.size() > 1)
                {
                    this.has_error = true;
                    this.errors.add("More than one rule matched while hit policy is unique");
                    break;
                }
            }
            // the output entries should be equal for hit policy "Any"
            else if(this.hitPolicy == HitPolicy.ANY)
            {
                if(matchedRules.size() == 0)
                    matchedRules.add(rule);
                else
                {
                    // new match rule's signature should be equal to exist matched rule
                    if(rule.getOutput().getSignature().equals(matchedRules.get(0).getOutput().getSignature()))
                        matchedRules.add(rule);
                    else
                    {
                        this.has_error = true;
                        this.errors.add("More than one rule with different output matched while hit policy is any");
                        break;
                    }
                }
            }
            else
            {
                matchedRules.add(rule);
            }
        }
        this.evaluated = true;
    }

    private boolean checkRules() {
        // check rules number
        if(this.rules == null || this.rules.size() == 0) {
            this.errors.add("There is no rule in decision table");
            return false;
        }

        // check rule output
        if(this.outputClauses == null || this.outputClauses.size() == 0) {
            this.errors.add("There is no output clause in decision table");
            return false;
        }

        boolean result;

        if(this.hitPolicy == HitPolicy.FIRST || this.hitPolicy == HitPolicy.RULE_ORDER)
        {
            result = true;
            // every rule should have rule no
            for (DecisionRule rule :
                    this.rules) {
                if(rule.getNo() == 0) {
                    result = false;
                    break;
                }
            }
        }
        else if(this.hitPolicy == HitPolicy.PRIORITY || this.hitPolicy == HitPolicy.OUTPUT_ORDER)
        {
            result = false;
            // at least one output clause should have allowed value list
            for (DecisionRuleOutputClause outputClause :
                    this.outputClauses) {
                if (outputClause.getAllowedValues() != null)
                {
                    result = true;
                    break;
                }
            }
            if(!result)
            {
                this.errors.add("There is no allowed values in any output clause while hit policy is priority or output order");
            }
        }
        else if(this.hitPolicy == HitPolicy.COLLECT)
        {
            // should have single output
            if(this.outputClauses.size() == 1)
                result = true;
            else
            {
                result = false;
                this.errors.add("The decision table should have single output while hit policy is collect");
            }
            if(this.aggregation == BuildInAggregation.NA)
            {
                result = false;
                this.errors.add("The aggregation of decision table should not be NA while hit policy is collect");
            }
            if((this.aggregation == BuildInAggregation.MAX
                    || this.aggregation == BuildInAggregation.MIN
                || this.aggregation == BuildInAggregation.SUM)
                    && this.outputClauses.get(0).getType() != DecisionRuleOutputType.NUMBER)
            {
                result = false;
                this.errors.add("The output type should be number while hit policy is 'collect' and aggregation is not 'count'");
            }
        }
        else
        {
            result = true;
        }
        return result;
    }

    private void sortRules() {
        // sort by rule number for First and Rule Order hit policy
        if(this.hitPolicy == HitPolicy.FIRST || this.hitPolicy == HitPolicy.RULE_ORDER)
            this.rules.sort(new DecisionRule.RuleNoComparator());
        // by output order for Priority and output order policy
        else if(this.hitPolicy == HitPolicy.PRIORITY || this.hitPolicy == HitPolicy.OUTPUT_ORDER)
            this.rules.sort(new DecisionRule.OutputOrderComparator());
    }

    public Map<String, Object> getOutput() {
        if(!this.evaluated) {
            this.run();
        }

        if(this.has_error)
        {
            return null;
        }

        Map<String, Object> output = new HashMap<>();

        boolean singleOutput = false;
        if(this.outputClauses.size() == 1) {
            singleOutput = true;
        }

        List<DecisionRule> matchedRules = new ArrayList<>();
        for (DecisionRule rule :
                this.rules) {
            if (rule.isMatch())
            {
                matchedRules.add(rule);
            }
        }

        if(matchedRules.size() == 0)
            return null;

        //single hit policies,U A P F
        if(this.hitPolicy == HitPolicy.UNIQUE
                || this.hitPolicy == HitPolicy.FIRST
                || this.hitPolicy == HitPolicy.ANY
                || this.hitPolicy == HitPolicy.PRIORITY)
        {
            List<DecisionRuleOutputEntry> ruleOutputEntries = matchedRules.get(0).getOutput().getEntries();
            if(singleOutput)
                output.put("Result", ruleOutputEntries.get(0).getValue());
            else{
                Map<String, Object> result = new HashMap<>();

                for (DecisionRuleOutputEntry outputEntry :
                        ruleOutputEntries) {
                    result.put(outputEntry.getName(), outputEntry.getValue());
                }
                output.put(this.outputLabel, result);
            }
        }
        //TODO: process other hit policies
        //multiple hit policies O R C
        else if(this.hitPolicy == HitPolicy.OUTPUT_ORDER || this.hitPolicy == HitPolicy.RULE_ORDER)
        {
            List<Object> outputList = new ArrayList<>();
            if(singleOutput)
            {
                for (DecisionRule rule :
                        matchedRules) {
                    outputList.add(rule.getOutput().getEntries().get(0).getValue());
                }
                output.put("Result", outputList);
            }
            else{
                for (DecisionRule rule :
                        matchedRules) {
                    Map<String, Object> result = new HashMap<>();

                    for (DecisionRuleOutputEntry outputEntry :
                            rule.getOutput().getEntries()) {
                        result.put(outputEntry.getName(), outputEntry.getValue());
                    }
                    outputList.add(result);
                }

                output.put(this.outputLabel, outputList);
            }
        }
        else if(this.hitPolicy == HitPolicy.COLLECT)
        {
            ArrayList<Object> output_collection = new ArrayList<>();

            for (DecisionRule rule :
                    matchedRules) {
                output_collection.add(rule.getOutput().getEntries().get(0).getValue());
            }
            Aggregator aggregator = new Aggregator(this.aggregation);
            output.put("Result", aggregator.run(output_collection));
        }


        return output;
    }

    public Map<String, Object> getOutputAnnotation() {
        if(!this.evaluated) {
            this.run();
        }

        if(this.has_error)
            return null;

        if(this.annotationClauses == null)
            return null;

        Map<String, Object> annotationResult = new HashMap<>();

        boolean singleAnnotationResult = false;
        if(this.annotationClauses.size() == 1) {
            singleAnnotationResult = true;
        }

        List<DecisionRule> matchedRules = new ArrayList<>();
        for (DecisionRule rule :
                this.rules) {
            if (rule.isMatch())
            {
                matchedRules.add(rule);
            }
        }

        if(matchedRules.size() == 0)
            return null;

        //single hit policies,U A P F
        if(this.hitPolicy == HitPolicy.UNIQUE
                || this.hitPolicy == HitPolicy.FIRST
                || this.hitPolicy == HitPolicy.ANY
                || this.hitPolicy == HitPolicy.PRIORITY)
        {
            List<DecisionRuleAnnotationEntry> ruleAnnotationEntries = matchedRules.get(0).getAnnotation().getEntries();
            if(singleAnnotationResult)
                annotationResult.put(ruleAnnotationEntries.get(0).getName(), ruleAnnotationEntries.get(0).getValue());
            else{
                Map<String, Object> result = new HashMap<>();

                for (DecisionRuleAnnotationEntry annotationEntry :
                        ruleAnnotationEntries) {
                    result.put(annotationEntry.getName(), annotationEntry.getValue());
                }
                annotationResult.put(this.annotationLabel, result);
            }
        }
        //multiple hit policies O R C
        else if(this.hitPolicy == HitPolicy.OUTPUT_ORDER)
        {

        }
        else if(this.hitPolicy == HitPolicy.RULE_ORDER)
        {

        }
        else if(this.hitPolicy == HitPolicy.COLLECT)
        {

        }

        return annotationResult;
    }
}
