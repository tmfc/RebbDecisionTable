package tech.rebb.dt;

public class DecisionRuleOutput {
    private final String label;

    public String getLabel() {
        return label;
    }

    private final String expression;

    public String getExpression() {
        return expression;
    }

    private final DecisionRuleOutputType type;

    public DecisionRuleOutputType getType() {
        return type;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    private Object value;

    public Object getValue() {
        return value;
    }

    public DecisionRuleOutput(String label, String expression, DecisionRuleOutputType type) {
        this.label = label;
        this.expression = expression;
        this.type = type;
    }
}
