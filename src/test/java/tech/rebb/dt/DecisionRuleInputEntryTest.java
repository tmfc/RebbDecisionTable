package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DecisionRuleInputEntryTest {

    @Test
    public void testConstructor()
    {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");

        DecisionRuleInputEntry inputEntity = null;
        try {
            inputEntity = new DecisionRuleInputEntry(inputGPA,">3.5");
        } catch (RebbDTException e) {
            e.printStackTrace();
        }
        assertEquals("GPA",inputEntity.getClause().getName());
        assertEquals("gpa",inputEntity.getClause().getExpression());
        assertEquals(">3.5",inputEntity.getExpression());
        assertEquals("E795F0A1A4C637B5597E077833CF869B",inputEntity.getSignature());
    }

    @Test
    public void testConstructorThrowException()
    {
        RebbDTException exception = assertThrows(RebbDTException.class, ()->{new DecisionRuleInputEntry(null,">3.5");});

        assertEquals("Rule input clause should not be null", exception.getMessage());
    }

    @Test
    public void testConstructorThrowException2()
    {
        List<String> allowedValues = new ArrayList<>();
        allowedValues.add(">3.5");
        allowedValues.add(">3.0 and <=3.5");

        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa",allowedValues);

        RebbDTException exception = assertThrows(RebbDTException.class, ()->{new DecisionRuleInputEntry(inputGPA,">3.6");});

        assertEquals("Expression (>3.6) not in allowed value list(>3.5, >3.0 and <=3.5)", exception.getMessage());
    }
}

