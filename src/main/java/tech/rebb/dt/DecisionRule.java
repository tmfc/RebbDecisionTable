package tech.rebb.dt;

import java.util.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class DecisionRule {

    private final EvalVisitor engine;

    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    private int no;

    public void setNo(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    private boolean is_match;

    public boolean isMatch() {
        return is_match;
    }

    private boolean has_error;

    public boolean hasError() {
        return has_error;
    }

    private final List<String> errors;

    public List<String> getErrors() {
        return errors;
    }

    private final DecisionRuleInput input;

    public DecisionRuleInput getInputs() {
        return input;
    }

    public final DecisionRuleOutput output;

    public DecisionRuleOutput getOutput() {
        return output;
    }

    public final DecisionRuleAnnotation annotation;

    public DecisionRuleAnnotation getAnnotation() {
        return annotation;
    }
//
//    public List<DecisionRuleOutputEntry> getOutputs() {
//        return outputs;
//    }
//
//    private List<DecisionRuleOutputEntry> outputs;


    public DecisionRule(DecisionRuleInput input, DecisionRuleOutput output) {
        this(input, output, null);
    }

    public DecisionRule(DecisionRuleInput input, DecisionRuleOutput output, DecisionRuleAnnotation annotation) {
        this.engine = new EvalVisitor("", null);
        this.errors = new ArrayList<String>();

        this.input = input;
        this.output = output;
        this.annotation = annotation;
    }

    public String getSignature() {
        String strToHash = this.input.getSignature() + this.output.getSignature();
        if(this.annotation != null)
            return Helper.sign(strToHash + this.annotation.getSignature());
        else
            return Helper.sign(strToHash);
    }

    public boolean evaluate() throws RebbDTException {
        boolean result = true;
        // evaluate rule
        result = this.doEvaluateRuleInput(input);

        // rule satisfied
        if(result)
        {
            //evaluate output value
            for (DecisionRuleOutputEntry output:
                 this.output.getEntries())   {
                if(!Objects.equals(output.getExpression(), ""))
                {
                    Object value = this.doEvaluateRuleOutput(output);
                    //TODO: check value type
                    output.setValue(value);
                }
            }

        }
        this.is_match = result;
        return result;
    }

    private boolean doEvaluateRuleInput(DecisionRuleInput ruleInput)
    {
        for (DecisionRuleInputEntry entity: ruleInput.getEntries()) {

            String expression = entity.getExpression();
            CharStream input = CharStreams.fromString(expression);
            RebbDTLexer lexer = new RebbDTLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            RebbDTParser parser = new RebbDTParser(tokens);
            parser.addErrorListener(RebbDTErrorListener.INSTANCE);
            ParseTree tree = parser.unaryTests(); // parse

            if(RebbDTErrorListener.INSTANCE.hasError())
            {
                this.has_error = true;
                this.errors.add(RebbDTErrorListener.INSTANCE.getError());
                RebbDTErrorListener.INSTANCE.clearError();
                return false;
            }

            Object obj = this.obj;
            if(this.obj instanceof HashMap)
            {
                String exp = entity.getClause().getExpression();
                obj = ((HashMap<String, Object>) this.obj).get(exp);
            }

            engine.setObject(obj);

            engine.visit(tree);

            if(!engine.isValid())
            {
                this.has_error = true;
                String error_message;
                if(obj == null)
                    error_message = "rule object is null";
                else
                    error_message = obj.toString() + " " + expression + " failed";
                if(engine.getError() != null && !engine.getError().equals(""))
                    error_message += "(" + engine.getError() + ")";
                this.errors.add(error_message);
                return false;
            }
        }
        return true;
    }

    //TODO add output eval visitor
    private Object doEvaluateRuleOutput(DecisionRuleOutputEntry ruleOutput)
    {
//        String expression = ruleOutput.getExpression();
//        CharStream input = CharStreams.fromString(expression);
//        RebbDTLexer lexer = new RebbDTLexer(input);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        RebbDTParser parser = new RebbDTParser(tokens);
//        parser.addErrorListener(RebbDTErrorListener.INSTANCE);
//        ParseTree tree = parser.unaryTests(); // parse
//
//        if(RebbDTErrorListener.INSTANCE.hasError())
//        {
//            this.has_error = true;
//            this.errors.add(RebbDTErrorListener.INSTANCE.getError());
//            RebbDTErrorListener.INSTANCE.clearError();
//            return false;
//        }
//
//        Object obj = ruleOutput.getObject();
//        engine.setObject(obj);
//
//        engine.visit(tree);
//
//        if(!engine.isValid())
//        {
//            this.has_error = true;
//            String error_message;
//            if(obj == null)
//                error_message = "rule object is null";
//            else
//                error_message = obj.toString() + " " + expression + " failed";
//            if(engine.getError() != null && !engine.getError().equals(""))
//                error_message += "(" + engine.getError() + ")";
//            this.errors.add(error_message);
//            return false;
//        }
//        return true;
        return null;
    }


    public static class RuleNoComparator implements Comparator<DecisionRule>
    {

        @Override
        public int compare(DecisionRule o1, DecisionRule o2) {
            return o1.getNo() - o2.getNo();
        }
    }

    public static class OutputOrderComparator implements Comparator<DecisionRule>
    {
        @Override
        public int compare(DecisionRule o1, DecisionRule o2) {
            List<DecisionRuleOutputEntry> outputEntries1 = o1.getOutput().getEntries();
            List<DecisionRuleOutputEntry> outputEntries2 = o2.getOutput().getEntries();
            if(outputEntries1.size() != outputEntries2.size())
                return 0;

            int result = 0;
            for(int i = 0; i< outputEntries1.size(); i ++)
            {
                DecisionRuleOutputEntry entry1 = outputEntries1.get(i);
                DecisionRuleOutputEntry entry2 = outputEntries2.get(i);

                int order1 = entry1.getOutputOrder();
                int order2 = entry2.getOutputOrder();
                if(order1 != order2)
                {
                    result = order1 - order2;
                    break;
                }
            }
            return result;
        }
    }
}
