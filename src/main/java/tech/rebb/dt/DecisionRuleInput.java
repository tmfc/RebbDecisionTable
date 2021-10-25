package tech.rebb.dt;

public class DecisionRuleInput {

    private final int ruleNumber;

    public int getRuleNumber() {
        return ruleNumber;
    }

    private final Object object;

    public Object getObject() {
        return object;
    }

    private final String expression;

    public String getExpression() {
        return expression;
    }

    public DecisionRuleInput(int ruleNumber, Object object, String expression) {
        this.ruleNumber = ruleNumber;
        this.object = object;
        this.expression = expression;
    }
}
