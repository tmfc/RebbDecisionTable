package tech.rebb.dt;

public class DecisionRuleInputEntry {

    private final DecisionRuleInputClause clause;

    public DecisionRuleInputClause getClause() {
        return clause;
    }

    private final String expression;

    public String getExpression() {
        return expression;
    }

    public DecisionRuleInputEntry(DecisionRuleInputClause clause, String expression) {
        this.clause = clause;
        this.expression = expression;
    }
}
