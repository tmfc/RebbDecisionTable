package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DecisionRuleAnnotationEntryTest {

    @Test
    public void testConstructor() throws RebbDTException {
        DecisionRuleAnnotationClause annotationRemark = new DecisionRuleAnnotationClause("Remark");

        DecisionRuleAnnotationEntry annotationEntity = new DecisionRuleAnnotationEntry(annotationRemark, "Excellent");
        assertEquals("Remark",annotationEntity.getClause().getName());
        assertEquals("Excellent",annotationEntity.getValue());
    }

    @Test
    public void testConstructorThrowException()
    {
        RebbDTException exception = assertThrows(RebbDTException.class, ()->{new DecisionRuleAnnotationEntry(null, "Excellent");});

        assertEquals("Rule annotation clause should not be null", exception.getMessage());

    }
}

