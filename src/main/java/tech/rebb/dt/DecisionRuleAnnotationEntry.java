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

    private final String signature;

    public String getSignature() {
        return signature;
    }

    public DecisionRuleAnnotationEntry(DecisionRuleAnnotationClause clause, Object value) throws RebbDTException {
        if(clause == null)
            throw new RebbDTException("Rule annotation clause should not be null");

        this.clause = clause;
        this.value = value;

        this.signature = Helper.sign(this.clause.getSignature() + this.value.toString());
    }

    public String getName() {
        return this.clause.getName();
    }
}
