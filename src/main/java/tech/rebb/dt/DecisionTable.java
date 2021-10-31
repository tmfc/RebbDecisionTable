package tech.rebb.dt;

import apple.laf.JRSUIConstants;

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

    private List<DecisionRule> rules;

    public List<DecisionRule> getRules() {
        return rules;
    }

//    public void setRules(List<DecisionRule> rules) {
//        this.rules = rules;
//    }

    public void addRule(DecisionRule rule)
    {
        if(this.rules == null)
            this.rules = new ArrayList<>();
        this.rules.add(rule);
        if(this.outputClauses == null)
            this.outputClauses = new ArrayList<>();
        if(this.outputClauses.size() == 0)
        {
            for (DecisionRuleOutputEntry outputEntry :
                    rule.getOutput().getEntries()) {
                this.outputClauses.add(outputEntry.getClause());
            }
        }
    }

    private String outputLabel;

    public String getOutputLabel() {
        return outputLabel;
    }

    public void setOutputLabel(String outputLabel) {
        this.outputLabel = outputLabel;
    }

    public DecisionTable(String name, Object obj, HitPolicy hitPolicy, BuildInAggregation aggregation) {
        this.name = name;
        this.obj = obj;
        this.hitPolicy = hitPolicy;
        this.aggregation = aggregation;

        this.errors = new ArrayList<>();
        this.evaluated = false;
    }

    public DecisionTable(String name, Object obj)
    {
        this(name, obj, HitPolicy.UNIQUE, BuildInAggregation.NA);
    }

    public void run()
    {
        // check rules
        if(this.rules == null || this.rules.size() == 0) {
            this.has_error = true;
            this.errors.add("There is no rule in decision table");
        }

        // evaluate rules
        for (DecisionRule rule :
                this.rules) {
            rule.setObj(this.obj);
            boolean result = rule.evaluate();
            // if hit policy is unique or first, means no more rule need to be evaluated
            if((this.hitPolicy == HitPolicy.UNIQUE || this.hitPolicy == HitPolicy.FIRST)
                && result)
            {
                break;
            }
        }
        this.evaluated = true;
    }

    public Map<String, Object> getOutput() {

        Map<String, Object> output = new HashMap<>();

        boolean singleOutput = false;
        if(this.outputClauses.size() == 1) {
            singleOutput = true;
        }

        List<DecisionRule> matchedRules = new ArrayList<>();
        if(!this.evaluated) {
            this.run();
        }
        for (DecisionRule rule :
                this.rules) {
            if (rule.is_match)
            {
                matchedRules.add(rule);
            }
        }

        if(matchedRules.size() == 0)
            return output;

        if(this.hitPolicy == HitPolicy.UNIQUE || this.hitPolicy == HitPolicy.FIRST)
        {
            List<DecisionRuleOutputEntry> ruleOutputEntries = matchedRules.get(0).getOutput().getEntries();
            if(singleOutput)
                output.put("Result", ruleOutputEntries.get(0).getValue());
            else{
                Map<String, Object> result = new HashMap<>();

                for (DecisionRuleOutputEntry outputEntry :
                        ruleOutputEntries) {
                    result.put(outputEntry.getClause().getName(), outputEntry.getValue());
                }
                output.put(this.outputLabel, result);
            }
        }
        //TODO: process other hit policies

        return output;
    }
}
