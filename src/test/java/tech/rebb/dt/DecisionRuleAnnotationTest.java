package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecisionRuleAnnotationTest {

    @Test
    public void testConstructor() throws RebbDTException {
        DecisionRuleAnnotationClause annotationRemark = new DecisionRuleAnnotationClause("Remark");
        DecisionRuleAnnotationEntry annotationEntry = new DecisionRuleAnnotationEntry(annotationRemark, "Excellent");

        DecisionRuleAnnotation annotation = new DecisionRuleAnnotation();
        boolean result = annotation.addEntry(null);
        assertFalse(result);

        result = annotation.addEntry(annotationEntry);
        assertTrue(result);

        assertEquals("Remark",annotation.getEntries().get(0).getClause().getName());
        assertEquals("Excellent",annotation.getEntries().get(0).getValue());
    }

    @Test
    public void testDuplicatedClause() throws RebbDTException {
        DecisionRuleAnnotationClause annotationRemark = new DecisionRuleAnnotationClause("Remark");
        DecisionRuleAnnotationEntry annotationEntry = new DecisionRuleAnnotationEntry(annotationRemark, "Excellent");

        DecisionRuleAnnotation annotation = new DecisionRuleAnnotation();
        boolean result = annotation.addEntry(annotationEntry);
        assertTrue(result);

        result = annotation.addEntry(annotationEntry);
        assertFalse(result);

        DecisionRuleAnnotationEntry annotationEntryDup = new DecisionRuleAnnotationEntry(annotationRemark, "Excellent");
        result = annotation.addEntry(annotationEntryDup);
        assertFalse(result);

        DecisionRuleAnnotationEntry annotationEntry2 = new DecisionRuleAnnotationEntry(annotationRemark, "Great");
        result = annotation.addEntry(annotationEntry2);
        assertFalse(result);

        assertEquals(1, annotation.getEntries().size());

        DecisionRuleAnnotationClause annotationError = new DecisionRuleAnnotationClause("Error");
        DecisionRuleAnnotationEntry annotationEntryError = new DecisionRuleAnnotationEntry(annotationError, "");

        result = annotation.addEntry(annotationEntryError);
        assertTrue(result);

        assertEquals(2, annotation.getEntries().size());
    }
}
