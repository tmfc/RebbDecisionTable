package tech.rebb.dt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DecisionRuleInputClauseTest {

    @Test
    public void testConstructor()
    {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        assertEquals("GPA",inputGPA.getName());
        assertEquals("gpa",inputGPA.getExpression());
        assertEquals("489ACADD0C96EA67DDD5D57117939222",inputGPA.getSignature());
    }
    @Test
    public void testSignature()
    {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        assertEquals("489ACADD0C96EA67DDD5D57117939222",inputGPA.getSignature());

        DecisionRuleInputClause inputGPA2 = new DecisionRuleInputClause("GPA","gpa");
        assertEquals("489ACADD0C96EA67DDD5D57117939222",inputGPA2.getSignature());

        DecisionRuleInputClause inputGPA3 = new DecisionRuleInputClause("GPA3","gpa3");
        assertNotEquals("489ACADD0C96EA67DDD5D57117939222",inputGPA3.getSignature());
        assertEquals("9ED33BDF58F6E21FE0F55A26D1B16630",inputGPA3.getSignature());
    }
}

