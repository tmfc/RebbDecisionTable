package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecisionRuleOutputEntryTest {

    @Test
    public void testConstructor()
    {
        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);

        DecisionRuleOutputEntry outputEntry = new DecisionRuleOutputEntry(outputRank, "A");
        assertEquals("Rank", outputEntry.getClause().getName());
        assertEquals("", outputEntry.getClause().getExpression());
        assertEquals(DecisionRuleOutputType.STRING, outputEntry.getClause().getType());
    }
    @Test
    public void testSetValue()
    {
        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);

        DecisionRuleOutputEntry output = new DecisionRuleOutputEntry(outputRank, "A");
        output.setValue("B");
        assertEquals("B", output.getValue());
    }
}

