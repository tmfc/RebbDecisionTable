package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class DecisionRuleTest {

    @Test
    public void testConstructor() throws RebbDTException {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity = new DecisionRuleInputEntry(inputGPA,">3.5");
        input.addEntry(inputEntity);

        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutput output = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntry = new DecisionRuleOutputEntry(outputRank, "A");
        output.addEntry(outputEntry);

        DecisionRule rule = new DecisionRule(input, output);
        rule.setObj(3.6);

        assertEquals(3.6, rule.getObj());
        assertEquals(1, rule.getOutput().getEntries().size());
    }

    @Test
    public void testSingleInputEntity() throws RebbDTException {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity = new DecisionRuleInputEntry(inputGPA,">3.5");
        input.addEntry(inputEntity);

        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutput output = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntry = new DecisionRuleOutputEntry(outputRank, "A");
        output.addEntry(outputEntry);

        DecisionRule rule = new DecisionRule(input, output);
        rule.setObj(3.6);

        boolean result = rule.evaluate();
        assertTrue(result);
        assertTrue(rule.isMatch());
        assertEquals("A", rule.getOutput().getEntries().get(0).getValue());

        rule.setObj(3.0);

        result = rule.evaluate();
        assertFalse(result);
        assertFalse(rule.isMatch());
        assertEquals("A", rule.getOutput().getEntries().get(0).getValue());
    }

    @Test
    public void testMultiplyInputEntity() throws RebbDTException {
        // input clause and entity 1
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInputEntry inputEntity1 = new DecisionRuleInputEntry(inputGPA,">3.5");

        // input clause and entity 2
        DecisionRuleInputClause inputAge = new DecisionRuleInputClause("AGE","age");
        DecisionRuleInputEntry inputEntity2 = new DecisionRuleInputEntry(inputAge,"<35");

        // input
        DecisionRuleInput input = new DecisionRuleInput();
        input.addEntry(inputEntity1);
        input.addEntry(inputEntity2);

        // output
        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutput output = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntry = new DecisionRuleOutputEntry(outputRank, "A");
        output.addEntry(outputEntry);

        // rule
        HashMap<String,Object> obj = new HashMap<>();
        obj.put("gpa", 3.6);
        obj.put("age", 30);
        DecisionRule rule = new DecisionRule(input, output);
        rule.setObj(obj);

        boolean result = rule.evaluate();
        assertTrue(result);
        assertTrue(rule.isMatch());
        assertEquals("A", rule.getOutput().getEntries().get(0).getValue());
    }

    @Test
    public void testMultiplyOutputEntity() throws RebbDTException {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity = new DecisionRuleInputEntry(inputGPA,">3.5");
        input.addEntry(inputEntity);

        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutput output = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntry = new DecisionRuleOutputEntry(outputRank, "A");
        output.addEntry(outputEntry);

        DecisionRule rule = new DecisionRule(input, output);
        rule.setObj(3.6);

        boolean result = rule.evaluate();
        assertTrue(result);
        assertTrue(rule.isMatch());
        assertEquals("A", rule.getOutput().getEntries().get(0).getValue());

        rule.setObj(3.0);

        result = rule.evaluate();
        assertFalse(result);
        assertFalse(rule.isMatch());
        assertEquals("A", rule.getOutput().getEntries().get(0).getValue());
    }

}

