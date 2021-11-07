package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DecisionRuleOutputEntryTest {

    @Test
    public void testConstructor() throws RebbDTException {
        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);

        DecisionRuleOutputEntry outputEntry = new DecisionRuleOutputEntry(outputRank, "A");
        assertEquals("Rank", outputEntry.getName());
        assertEquals("", outputEntry.getExpression());
        assertEquals(DecisionRuleOutputType.STRING, outputEntry.getClause().getType());
        assertEquals("C510845DFAD946D88AEEC0C138118C51", outputEntry.getSignature());
    }

    @Test
    public void testConstructorThrowException() {
        RebbDTException exception = assertThrows(RebbDTException.class, ()->{new DecisionRuleOutputEntry(null,"A");});

        assertEquals("Rule output clause should not be null", exception.getMessage());
    }

    @Test
    public void testConstructorThrowException2() {
        List<String> allowedValues = new ArrayList<>();
        allowedValues.add("A");
        allowedValues.add("B");
        allowedValues.add("C");

        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING, allowedValues);

        RebbDTException exception = assertThrows(RebbDTException.class, ()->{new DecisionRuleOutputEntry(outputRank,"X");});

        assertEquals("Value (X) not in allowed value list(A, B, C)", exception.getMessage());
    }

    @Test
    public void testSetValue() throws RebbDTException {
        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);

        DecisionRuleOutputEntry output = new DecisionRuleOutputEntry(outputRank, "A");
        output.setValue("B");
        assertEquals("B", output.getValue());
    }

    @Test
    public void testSetValueThrowException() throws RebbDTException {
        List<String> allowedValues = new ArrayList<>();
        allowedValues.add("A");
        allowedValues.add("B");
        allowedValues.add("C");

        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING, allowedValues);

        DecisionRuleOutputEntry output = new DecisionRuleOutputEntry(outputRank, "A");

        RebbDTException exception = assertThrows(RebbDTException.class, ()->{output.setValue("X");});

        assertEquals("Value (X) not in allowed value list(A, B, C)", exception.getMessage());

        assertEquals("A", output.getValue());
    }
}

