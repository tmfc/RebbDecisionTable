package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecisionRuleInputTest {

    @Test
    public void testConstructor() throws RebbDTException {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInputEntry inputEntity = new DecisionRuleInputEntry(inputGPA,">3.5");

        DecisionRuleInput input = new DecisionRuleInput();
        boolean result = input.addEntry(null);
        assertFalse(result);

        result = input.addEntry(inputEntity);
        assertTrue(result);

        assertEquals(1, input.getEntries().size());
        assertEquals("GPA",input.getEntries().get(0).getClause().getName());
        assertEquals("gpa",input.getEntries().get(0).getClause().getExpression());
        assertEquals(">3.5",input.getEntries().get(0).getExpression());
    }

    @Test
    public void testDuplicatedClause() throws RebbDTException {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInputEntry inputEntityGPA = new DecisionRuleInputEntry(inputGPA,">3.5");

        DecisionRuleInput input = new DecisionRuleInput();
        boolean result = input.addEntry(inputEntityGPA);
        assertTrue(result);

        DecisionRuleInputEntry inputEntityGPA2 = new DecisionRuleInputEntry(inputGPA,">3.7");
        result = input.addEntry(inputEntityGPA2);
        assertFalse(result);

        assertEquals(1, input.getEntries().size());

        DecisionRuleInputClause inputRank = new DecisionRuleInputClause("Rank","rank");
        DecisionRuleInputEntry inputEntityRank = new DecisionRuleInputEntry(inputRank,"<=10");

        result = input.addEntry(inputEntityRank);
        assertTrue(result);

        assertEquals(2, input.getEntries().size());
    }
}
