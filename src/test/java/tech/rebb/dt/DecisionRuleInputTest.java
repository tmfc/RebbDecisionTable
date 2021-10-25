package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecisionRuleInputTest {

    @Test
    public void testConstructor()
    {
        DecisionRuleInput input = new DecisionRuleInput(1,3.6,">3.5");
        assertEquals(1,input.getRuleNumber());
        assertEquals(3.6,input.getObject());
        assertEquals(">3.5",input.getExpression());
    }
}

