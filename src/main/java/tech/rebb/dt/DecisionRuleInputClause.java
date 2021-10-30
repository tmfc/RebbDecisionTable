package tech.rebb.dt;


import java.util.List;
import java.util.Collections;

public class DecisionRuleInputClause {

    private final String name;

    public String getName() {
        return name;
    }

    private final String expression;

    public String getExpression() {
        return expression;
    }

    public List<String> getAllowedValues() {
        return allowedValues;
    }

    private final List<String> allowedValues;

    public DecisionRuleInputClause(String name, String expression, List<String> allowedValues) {
        this.name = name;
        this.expression = expression;
        this.allowedValues = allowedValues;
    }

    public DecisionRuleInputClause(String name, String expression) {
        this(name, expression, Collections.emptyList());
    }
}
