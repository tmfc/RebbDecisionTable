package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecisionRuleOutputTest {

    @Test
    public void testConstructor()
    {
        DecisionRuleOutput output = new DecisionRuleOutput("label","",DecisionRuleOutputType.BOOLEAN);
        assertEquals("label",output.getLabel());
        assertEquals("",output.getExpression());
        assertEquals(DecisionRuleOutputType.BOOLEAN,output.getType());
    }
    @Test
    public void testSetValue()
    {
        DecisionRuleOutput output = new DecisionRuleOutput("label","",  DecisionRuleOutputType.BOOLEAN);
        output.setValue("value");
        assertEquals(DecisionRuleOutputType.BOOLEAN,output.getValue());
    }


}

