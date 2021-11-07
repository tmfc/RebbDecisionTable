package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecisionRuleOutputTest {

    @Test
    public void testConstructor() throws RebbDTException {
        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutputEntry outputEntity = new DecisionRuleOutputEntry(outputRank,"A");

        DecisionRuleOutput output = new DecisionRuleOutput();
        output.addEntry(outputEntity);

        assertEquals("Rank",output.getEntries().get(0).getClause().getName());
        assertEquals("",output.getEntries().get(0).getClause().getExpression());
        assertEquals("A",output.getEntries().get(0).getValue());
    }

    @Test
    public void testDuplicatedEntry() throws RebbDTException {
        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutputEntry outputEntity = new DecisionRuleOutputEntry(outputRank,"A");

        DecisionRuleOutput output = new DecisionRuleOutput();
        boolean result = output.addEntry(outputEntity);
        assertTrue(result);

        result = output.addEntry(outputEntity);
        assertFalse(result);

        DecisionRuleOutputEntry outputEntityDup = new DecisionRuleOutputEntry(outputRank,"A");
        result = output.addEntry(outputEntityDup);
        assertFalse(result);

        DecisionRuleOutputEntry outputEntityB = new DecisionRuleOutputEntry(outputRank,"B");
        result = output.addEntry(outputEntityB);
        assertTrue(result);

        assertEquals(2, output.getEntries().size());
    }
}

