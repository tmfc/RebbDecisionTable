package tech.rebb.dt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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

    public boolean is_match;

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

    private final List<DecisionRuleInput> inputs;

    public List<DecisionRuleInput> getInputs() {
        return inputs;
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


    public DecisionRule(List<DecisionRuleInput> inputs, DecisionRuleOutput output) {
        this(inputs, output, null);
    }

    public DecisionRule(List<DecisionRuleInput> inputs, DecisionRuleOutput output, DecisionRuleAnnotation annotation) {
        this.engine = new EvalVisitor("", null);
        this.errors = new ArrayList<String>();

        this.inputs = inputs;
        this.output = output;
        this.annotation = annotation;
    }

    public boolean evaluate()
    {
        boolean result = true;
        // evaluate every rule
        for (DecisionRuleInput input:
             this.inputs) {
            boolean ruleResult = this.doEvaluateRuleInput(input);
            result = result && ruleResult;
        }
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

}
