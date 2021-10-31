package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecisionRuleOutputTest {

    @Test
    public void testConstructor()
    {
        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutputEntry outputEntity = new DecisionRuleOutputEntry(outputRank,"A");

        DecisionRuleOutput output = new DecisionRuleOutput("");
        output.addEntity(outputEntity);

        assertEquals("Rank",output.getEntries().get(0).getClause().getName());
        assertEquals("",output.getEntries().get(0).getClause().getExpression());
        assertEquals("A",output.getEntries().get(0).getValue());
    }
}

