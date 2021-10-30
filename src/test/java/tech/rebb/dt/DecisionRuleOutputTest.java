package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecisionRuleOutputTest {

    @Test
    public void testConstructor()
    {
        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);

        DecisionRuleOutput output = new DecisionRuleOutput(outputRank);
        assertEquals("Rank", output.getClause().getName());
        assertEquals("", output.getClause().getExpression());
        assertEquals(DecisionRuleOutputType.STRING, output.getClause().getType());
    }
    @Test
    public void testSetValue()
    {
        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);

        DecisionRuleOutput output = new DecisionRuleOutput(outputRank);
        output.setValue("A");
        assertEquals("A", output.getValue());
    }
}

