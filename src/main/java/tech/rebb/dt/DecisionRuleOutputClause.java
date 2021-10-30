package tech.rebb.dt;

public class DecisionRuleOutputClause {
    private final String name;

    public String getName() {
        return name;
    }

    private final String expression;

    public String getExpression() {
        return expression;
    }

    private final DecisionRuleOutputType type;

    public DecisionRuleOutputType getType() {
        return type;
    }

    public DecisionRuleOutputClause(String name, String expression, DecisionRuleOutputType type) {
        this.name = name;
        this.expression = expression;
        this.type = type;
    }
}
