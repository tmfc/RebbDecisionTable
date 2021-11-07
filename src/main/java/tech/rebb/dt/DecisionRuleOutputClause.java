package tech.rebb.dt;

import java.util.List;

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

    private final List<String> allowedValues;

    public List<String> getAllowedValues() {
        return allowedValues;
    }

    private String defaultValue;

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public DecisionRuleOutputClause(String name, String expression, DecisionRuleOutputType type) {
        this(name, expression, type, null);
    }

    public DecisionRuleOutputClause(String name, String expression, DecisionRuleOutputType type, List<String> allowedValues) {
        this.name = name;
        this.expression = expression;
        this.type = type;
        this.allowedValues = allowedValues;
    }
}
