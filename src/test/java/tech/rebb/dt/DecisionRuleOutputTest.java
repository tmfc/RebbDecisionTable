package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecisionRuleOutputTest {

    @Test
    public void testConstructor() throws RebbDTException {
        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutputEntry outputEntity = new DecisionRuleOutputEntry(outputRank,"A");

        DecisionRuleOutput output = new DecisionRuleOutput();
        boolean result = output.addEntry(null);
        assertFalse(result);

        result = output.addEntry(outputEntity);
        assertTrue(result);

        assertEquals("Rank",output.getEntries().get(0).getClause().getName());
        assertEquals("",output.getEntries().get(0).getClause().getExpression());
        assertEquals("A",output.getEntries().get(0).getValue());
    }

    @Test
    public void testDuplicatedClause() throws RebbDTException {
        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutputEntry outputEntityRank = new DecisionRuleOutputEntry(outputRank,"A");

        DecisionRuleOutput output = new DecisionRuleOutput();
        boolean result = output.addEntry(outputEntityRank);
        assertTrue(result);

        DecisionRuleOutputEntry outputEntityRank2 = new DecisionRuleOutputEntry(outputRank,"A");
        result = output.addEntry(outputEntityRank2);
        assertFalse(result);

        assertEquals(1, output.getEntries().size());

        DecisionRuleOutputClause outputNote = new DecisionRuleOutputClause("Note","",DecisionRuleOutputType.STRING);
        DecisionRuleOutputEntry outputEntityNote = new DecisionRuleOutputEntry(outputNote,"Best");

        result = output.addEntry(outputEntityNote);
        assertTrue(result);

        assertEquals(2, output.getEntries().size());
    }
}

