package tech.rebb.dt;


import java.util.List;

public class DecisionRuleInputClause {

    private final String name;

    public String getName() {
        return name;
    }

    private final String expression;

    public String getExpression() {
        return expression;
    }

    private final List<String> allowedValues;

    public List<String> getAllowedValues() {
        return allowedValues;
    }

    private final String signature;

    public String getSignature() {
        return signature;
    }

    public DecisionRuleInputClause(String name, String expression) {
        this(name, expression, null);
    }

    public DecisionRuleInputClause(String name, String expression, List<String> allowedValues) {
        this.name = name;
        this.expression = expression;
        this.allowedValues = allowedValues;

        String hash = null;
        String strToHash = this.name + this.expression;
        if(this.allowedValues != null)
            strToHash = this.name + this.expression + this.allowedValues;

        this.signature = Helper.sign(strToHash);
    }
}
