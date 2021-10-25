package tech.rebb.dt;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class DecisionRule {

    EvalVisitor engine;

    public boolean hasError() {
        return has_error;
    }

    private boolean has_error;

    public List<String> getErrors() {
        return errors;
    }

    private List<String> errors;

    private ArrayList<DecisionRuleInput> inputs;

    public ArrayList<DecisionRuleInput> getInputs() {
        return inputs;
    }

    public void setInputs(ArrayList<DecisionRuleInput> inputs) {
        this.inputs = inputs;
    }

    public ArrayList<DecisionRuleOutput> getOutputs() {
        return outputs;
    }

    private ArrayList<DecisionRuleOutput> outputs;

    public DecisionRule() {
        this.engine = new EvalVisitor("", null);
        this.errors = new ArrayList<String>();
    }

    public DecisionRule(ArrayList<DecisionRuleInput> inputs, ArrayList<DecisionRuleOutput> outputs) {
        this();
        this.inputs = inputs;
        this.outputs = outputs;
    }

    public boolean evaluate()
    {
        boolean result = true;
        // evaluate every rule
        for (DecisionRuleInput input:
             this.inputs) {
            boolean ruleResult = this.evaluateRuleInput(input);
            result = result && ruleResult;
        }
        // rule satisfied
        if(result)
        {
            //evaluate output value
            for (DecisionRuleOutput output:
                 this.outputs)   {
                if(!Objects.equals(output.getExpression(), ""))
                {
                    Object value = this.evaluateRuleOutput(output);
                    //TODO: check value type
                    output.setValue(value);
                }
            }
        }
        return result;
    }

    private boolean evaluateRuleInput(DecisionRuleInput ruleInput)
    {
        String expression = ruleInput.getExpression();
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

        Object obj = ruleInput.getObject();
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
        return true;
    }

    //TODO add output eval visitor
    private Object evaluateRuleOutput(DecisionRuleOutput ruleOutput)
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
