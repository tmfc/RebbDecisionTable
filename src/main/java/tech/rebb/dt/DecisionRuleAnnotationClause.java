package tech.rebb.dt;


public class DecisionRuleAnnotationClause {
    private final String name;

    public String getName() {
        return name;
    }

    private final String signature;

    public String getSignature() {
        return signature;
    }

    public DecisionRuleAnnotationClause(String name) {
        this.name = name;

        this.signature = Helper.sign(this.name);
    }
}
