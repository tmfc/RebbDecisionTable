package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecisionRuleInputTest {

    @Test
    public void testConstructor()
    {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInputEntry inputEntity = new DecisionRuleInputEntry(inputGPA,">3.5");

        DecisionRuleInput input = new DecisionRuleInput();
        input.addEntity(inputEntity);

        assertEquals("GPA",input.getEntries().get(0).getClause().getName());
        assertEquals("gpa",input.getEntries().get(0).getClause().getExpression());
        assertEquals(">3.5",input.getEntries().get(0).getExpression());
    }
}

