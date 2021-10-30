package tech.rebb.dt;

public class DecisionRuleOutput {
    private final DecisionRuleOutputClause clause;

    public DecisionRuleOutputClause getClause() {
        return clause;
    }

    private Object value;

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public DecisionRuleOutput(DecisionRuleOutputClause clause) {
        this.clause = clause;
    }

    public String getExpression() {
        return this.clause.getExpression();
    }

}
