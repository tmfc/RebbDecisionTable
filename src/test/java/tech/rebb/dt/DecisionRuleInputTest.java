package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecisionRuleInputTest {

    @Test
    public void testConstructor() throws RebbDTException {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInputEntry inputEntity = new DecisionRuleInputEntry(inputGPA,">3.5");

        DecisionRuleInput input = new DecisionRuleInput();
        input.addEntry(inputEntity);

        assertEquals("GPA",input.getEntries().get(0).getClause().getName());
        assertEquals("gpa",input.getEntries().get(0).getClause().getExpression());
        assertEquals(">3.5",input.getEntries().get(0).getExpression());
    }
    @Test
    public void testDuplicatedEntry() throws RebbDTException {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInputEntry inputEntity = new DecisionRuleInputEntry(inputGPA,">3.5");

        DecisionRuleInput input = new DecisionRuleInput();
        boolean result = input.addEntry(inputEntity);
        assertTrue(result);

        result = input.addEntry(inputEntity);
        assertFalse(result);

        DecisionRuleInputEntry inputEntityDup = new DecisionRuleInputEntry(inputGPA,">3.5");
        result = input.addEntry(inputEntityDup);
        assertFalse(result);

        DecisionRuleInputEntry inputEntity2 = new DecisionRuleInputEntry(inputGPA,">3.0 and <=3.5");
        result = input.addEntry(inputEntity2);
        assertTrue(result);

        assertEquals(2, input.getEntries().size());
    }

}

