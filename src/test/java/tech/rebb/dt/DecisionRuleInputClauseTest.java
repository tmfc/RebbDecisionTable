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
    }
}

