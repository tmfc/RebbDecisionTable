package tech.rebb.dt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DecisionRuleOutputClauseTest {

    @Test
    public void testConstructor()
    {
        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        assertEquals("Rank",outputRank.getName());
        assertEquals("",outputRank.getExpression());
        assertEquals(DecisionRuleOutputType.STRING,outputRank.getType());

        assertEquals("0009C032AB88B5C6DC4D0D4BF3992B91",outputRank.getSignature());
    }

    @Test
    public void testSignature()
    {
        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        assertEquals("0009C032AB88B5C6DC4D0D4BF3992B91",outputRank.getSignature());

        DecisionRuleOutputClause outputRankSame = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        assertEquals("0009C032AB88B5C6DC4D0D4BF3992B91",outputRankSame.getSignature());

        DecisionRuleOutputClause outputRankDiff = new DecisionRuleOutputClause("Rank3","",DecisionRuleOutputType.STRING);
        assertNotEquals("0009C032AB88B5C6DC4D0D4BF3992B91",outputRankDiff.getSignature());
        assertEquals("4F871EE6EC1D2BDF90B25511D41F868C",outputRankDiff.getSignature());
    }
}