package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecisionRuleAnnotationTest {

    @Test
    public void testConstructor()
    {
        DecisionRuleAnnotationClause annotationRemark = new DecisionRuleAnnotationClause("Remark");
        DecisionRuleAnnotationEntry annotationEntity = new DecisionRuleAnnotationEntry(annotationRemark, "Excellent");

        DecisionRuleAnnotation annotation = new DecisionRuleAnnotation();
        annotation.addEntry(annotationEntity);

        assertEquals("Remark",annotation.getEntries().get(0).getClause().getName());
        assertEquals("Excellent",annotation.getEntries().get(0).getValue());
    }
}

