package tech.rebb.dt;

import java.util.List;

public class DecisionRuleOutputEntry {
    private final DecisionRuleOutputClause clause;

    public DecisionRuleOutputClause getClause() {
        return clause;
    }

    private Object value;

    public void setValue(Object value) throws RebbDTException {
        if(clause.getAllowedValues() != null){
            List<String> allowedValues = clause.getAllowedValues();
            if(!allowedValues.contains(value.toString()))
                throw new RebbDTException("Value (" + value.toString() + ") not in allowed value list(" + String.join(", ", allowedValues) + ")");
        }
        //TODO: check value type
        this.value = value;

        this.signature = Helper.sign(this.clause.getSignature() + this.value.toString());
    }

    public Object getValue() {
        return value;
    }

    private String signature;

    public String getSignature() {
        return signature;
    }

    public DecisionRuleOutputEntry(DecisionRuleOutputClause clause, Object value) throws RebbDTException {
        if(clause == null)
            throw new RebbDTException("Rule output clause should not be null");

        // Check allowed value
        if(clause.getAllowedValues() != null){
            List<String> allowedValues = clause.getAllowedValues();
            if(!allowedValues.contains(value.toString()))
                throw new RebbDTException("Value (" + value.toString() + ") not in allowed value list(" + String.join(", ", allowedValues) + ")");
        }

        this.clause = clause;
        this.value = value;

        this.signature = Helper.sign(this.clause.getSignature() + this.value.toString());
    }

    public String getExpression() {
        return this.clause.getExpression();
    }
    public String getName() {
        return this.clause.getName();
    }

}
