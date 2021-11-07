package tech.rebb.dt;

public class DecisionRuleAnnotationEntry {
    private final DecisionRuleAnnotationClause clause;

    public DecisionRuleAnnotationClause getClause() {
        return clause;
    }

    private Object value;

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public DecisionRuleAnnotationEntry(DecisionRuleAnnotationClause clause, Object value) {
        this.clause = clause;
        this.value = value;
    }

    public String getName() {
        return this.clause.getName();
    }
}
