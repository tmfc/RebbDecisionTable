package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecisionRuleInputEntryTest {

    @Test
    public void testConstructor()
    {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");

        DecisionRuleInputEntry inputEntity = new DecisionRuleInputEntry(inputGPA,">3.5");
        assertEquals("GPA",inputEntity.getClause().getName());
        assertEquals("gpa",inputEntity.getClause().getExpression());
        assertEquals(">3.5",inputEntity.getExpression());
    }
}

