package tech.rebb.dt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecisionRuleOutputClauseTest {

    @Test
    public void testConstructor()
    {
        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        assertEquals("Rank",outputRank.getName());
        assertEquals("",outputRank.getExpression());
        assertEquals(DecisionRuleOutputType.STRING,outputRank.getType());
    }
}