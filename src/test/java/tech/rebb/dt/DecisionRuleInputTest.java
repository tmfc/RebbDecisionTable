package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecisionRuleInputTest {

    @Test
    public void testConstructor()
    {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");

        DecisionRuleInput input = new DecisionRuleInput(1, inputGPA,">3.5");
        assertEquals(1,input.getRuleNumber());
        assertEquals(">3.5",input.getExpression());
    }
}

