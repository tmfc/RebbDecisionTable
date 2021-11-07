package tech.rebb.dt;

public class DecisionRuleOutputEntry {
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

    public DecisionRuleOutputEntry(DecisionRuleOutputClause clause, Object value) {
        this.clause = clause;
        this.value = value;
    }


    public String getExpression() {
        return this.clause.getExpression();
    }
    public String getName() {
        return this.clause.getName();
    }

}
