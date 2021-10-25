package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecisionRuleOutputTest {

    @Test
    public void testConstructor()
    {
        DecisionRuleOutput output = new DecisionRuleOutput("label","","Boolean");
        assertEquals("label",output.getLabel());
        assertEquals("",output.getExpression());
        assertEquals("Boolean",output.getType());
    }
    @Test
    public void testSetValue()
    {
        DecisionRuleOutput output = new DecisionRuleOutput("label","","Boolean");
        output.setValue("value");
        assertEquals("value",output.getValue());
    }


}

