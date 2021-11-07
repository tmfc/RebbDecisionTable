package tech.rebb.dt;

import java.util.List;

public class DecisionRuleInputEntry {

    private final DecisionRuleInputClause clause;

    public DecisionRuleInputClause getClause() {
        return clause;
    }

    private final String expression;

    public String getExpression() {
        return expression;
    }

    private final String signature;

    public String getSignature() {
        return signature;
    }

    public DecisionRuleInputEntry(DecisionRuleInputClause clause, String expression) throws RebbDTException {
        if(clause == null)
            throw new RebbDTException("Rule input clause should not be null");

        // Check allowed value
        if(clause.getAllowedValues() != null){
            List<String> allowedValues = clause.getAllowedValues();
            if(!allowedValues.contains(expression))
                throw new RebbDTException("Expression (" + expression + ") not in allowed value list(" + String.join(", ", allowedValues) + ")");
        }

        this.clause = clause;
        this.expression = expression;
        this.signature = Helper.sign(this.clause.getSignature() + this.expression.toString());
    }
}
