package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DecisionRuleAnnotationClauseTest {

    @Test
    public void testConstructor()
    {
        DecisionRuleAnnotationClause annotationRemark = new DecisionRuleAnnotationClause("Remark");
        assertEquals("Remark",annotationRemark.getName());
        assertEquals("91921ADA405FD6BA65DFF028DF047CB6",annotationRemark.getSignature());
    }
    @Test
    public void testSignature()
    {
        DecisionRuleAnnotationClause annotationRemark = new DecisionRuleAnnotationClause("Remark");
        assertEquals("91921ADA405FD6BA65DFF028DF047CB6",annotationRemark.getSignature());

        DecisionRuleAnnotationClause annotationRemarkSame = new DecisionRuleAnnotationClause("Remark");
        assertEquals("91921ADA405FD6BA65DFF028DF047CB6",annotationRemarkSame.getSignature());

        DecisionRuleAnnotationClause annotationRemarkDiff = new DecisionRuleAnnotationClause("Remark3");
        assertNotEquals("91921ADA405FD6BA65DFF028DF047CB6",annotationRemarkDiff.getSignature());
        assertEquals("613D9649AB1B17814817848158D361F1",annotationRemarkDiff.getSignature());
    }
}

