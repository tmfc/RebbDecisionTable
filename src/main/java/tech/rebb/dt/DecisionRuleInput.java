package tech.rebb.dt;

public class DecisionRuleInput {

    private final DecisionRuleInputClause clause;

    public DecisionRuleInputClause getClause() {
        return clause;
    }

    private final int ruleNumber;

    public int getRuleNumber() {
        return ruleNumber;
    }

    private final String expression;

    public String getExpression() {
        return expression;
    }

    public DecisionRuleInput(int ruleNumber, DecisionRuleInputClause clause, String expression) {
        this.ruleNumber = ruleNumber;
        this.clause = clause;
        this.expression = expression;
    }
}
