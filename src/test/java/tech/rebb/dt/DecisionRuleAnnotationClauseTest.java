package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecisionRuleAnnotationClauseTest {

    @Test
    public void testConstructor()
    {
        DecisionRuleAnnotationClause annotationRemark = new DecisionRuleAnnotationClause("Remark");
        assertEquals("Remark",annotationRemark.getName());
    }
}

