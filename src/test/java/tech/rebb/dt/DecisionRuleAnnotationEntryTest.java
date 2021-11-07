package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecisionRuleAnnotationEntryTest {

    @Test
    public void testConstructor()
    {
        DecisionRuleAnnotationClause annotationRemark = new DecisionRuleAnnotationClause("Remark");

        DecisionRuleAnnotationEntry annotationEntity = new DecisionRuleAnnotationEntry(annotationRemark, "Excellent");
        assertEquals("Remark",annotationEntity.getClause().getName());
        assertEquals("Excellent",annotationEntity.getValue());
    }
}

