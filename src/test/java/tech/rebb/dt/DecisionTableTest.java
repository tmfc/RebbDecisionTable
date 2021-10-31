package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class DecisionTableTest {

    @Test
    public void testConstructor()
    {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity = new DecisionRuleInputEntry(inputGPA,">3.5");
        input.addEntity(inputEntity);

        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutput output = new DecisionRuleOutput("");
        DecisionRuleOutputEntry outputEntry = new DecisionRuleOutputEntry(outputRank, "A");
        output.addEntity(outputEntry);


        ArrayList<DecisionRuleInput> inputs = new ArrayList<>();
        ArrayList<DecisionRuleOutputEntry> outputs = new ArrayList<>();

        inputs.add(input);

        DecisionRule rule1 = new DecisionRule(inputs, output);

        DecisionTable dt = new DecisionTable("Test Decision Table", 3.6);
        dt.addRule(rule1);

        assertEquals("Test Decision Table", dt.getName());
        assertEquals(3.6, dt.getObj());
        assertEquals(1, dt.getRules().size());
        assertEquals(1, dt.getOutputClauses().size());
    }

    @Test
    public void testSingleRule()
    {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity = new DecisionRuleInputEntry(inputGPA,">3.5");
        input.addEntity(inputEntity);

        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutput output = new DecisionRuleOutput("");
        DecisionRuleOutputEntry outputEntry = new DecisionRuleOutputEntry(outputRank, "A");
        output.addEntity(outputEntry);

        ArrayList<DecisionRuleInput> inputs = new ArrayList<>();
        ArrayList<DecisionRuleOutputEntry> outputs = new ArrayList<>();

        inputs.add(input);

        DecisionRule rule1 = new DecisionRule(inputs, output);

        DecisionTable dt = new DecisionTable("Test Decision Table", 3.6);
        dt.addRule(rule1);

        dt.run();

        assertFalse(dt.hasError());
        assertEquals(1, dt.getOutput().size());
        assertEquals("A", dt.getOutput().get("Result"));
    }
    @Test
    public void testMultipleRules()
    {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input1 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity1 = new DecisionRuleInputEntry(inputGPA,">3.5");
        input1.addEntity(inputEntity1);


        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutput output = new DecisionRuleOutput("");
        DecisionRuleOutputEntry outputEntry = new DecisionRuleOutputEntry(outputRank, "A");
        output.addEntity(outputEntry);

        ArrayList<DecisionRuleInput> inputs = new ArrayList<>();
        ArrayList<DecisionRuleOutputEntry> outputs = new ArrayList<>();

        inputs.add(input1);

        DecisionRule rule1 = new DecisionRule(inputs, output);

        DecisionRuleInput input2 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity2 = new DecisionRuleInputEntry(inputGPA,">3.0");
        input2.addEntity(inputEntity2);

        DecisionRuleOutput output2 = new DecisionRuleOutput("");
        DecisionRuleOutputEntry outputEntity2 = new DecisionRuleOutputEntry(outputRank, "B");
        output2.addEntity(outputEntity2);

        inputs = new ArrayList<>();

        inputs.add(input2);

        DecisionRule rule2 = new DecisionRule(inputs, output);

        DecisionTable dt = new DecisionTable("Test Decision Table", 3.1);
        dt.addRule(rule1);
        dt.addRule(rule2);

        dt.run();

        assertFalse(dt.hasError());
        assertEquals(1, dt.getOutput().size());
        assertEquals("B", dt.getOutput().get("Result"));
    }

//    @Test
//    public void testMultiplyInputEntity()
//    {
//        // input clause and entity 1
//        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
//        DecisionRuleInputEntry inputEntity1 = new DecisionRuleInputEntry(inputGPA,">3.5");
//
//        // input clause and entity 2
//        DecisionRuleInputClause inputAge = new DecisionRuleInputClause("AGE","age");
//        DecisionRuleInputEntry inputEntity2 = new DecisionRuleInputEntry(inputGPA,"<35");
//
//        // input
//        DecisionRuleInput input = new DecisionRuleInput();
//        input.addEntity(inputEntity1);
//        input.addEntity(inputEntity2);
//
//        // output
//        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
//        DecisionRuleOutputEntry output = new DecisionRuleOutputEntry(outputRank, "A");
//
//
//        // rule
//        ArrayList<DecisionRuleInput> inputs = new ArrayList<>();
//        ArrayList<DecisionRuleOutputEntry> outputs = new ArrayList<>();
//
//        inputs.add(input);
//        outputs.add(output);
//
//        HashMap<String,Object> obj = new HashMap<>();
//        obj.put("gpa", 3.6);
//        obj.put("age", 30);
//        DecisionRule rule = new DecisionRule(obj, inputs, outputs);
//
//        boolean result = rule.evaluate();
//        assertTrue(result);
//        assertTrue(rule.isMatch());
//        assertEquals("A", rule.getOutputs().get(0).getValue());
//    }
//
//    @Test
//    public void testMultiplyOutputEntity()
//    {
//        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
//        DecisionRuleInput input = new DecisionRuleInput();
//        DecisionRuleInputEntry inputEntity = new DecisionRuleInputEntry(inputGPA,">3.5");
//        input.addEntity(inputEntity);
//
//        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
//        DecisionRuleOutputEntry output = new DecisionRuleOutputEntry(outputRank, "A");
//        ArrayList<DecisionRuleInput> inputs = new ArrayList<>();
//        ArrayList<DecisionRuleOutputEntry> outputs = new ArrayList<>();
//
//        inputs.add(input);
//        outputs.add(output);
//
//        DecisionRule rule = new DecisionRule(3.6, inputs, outputs);
//
//        boolean result = rule.evaluate();
//        assertTrue(result);
//        assertTrue(rule.isMatch());
//        assertEquals("A", rule.getOutputs().get(0).getValue());
//
//        rule = new DecisionRule(3.0, inputs, outputs);
//
//        result = rule.evaluate();
//        assertFalse(result);
//        assertFalse(rule.isMatch());
//        assertEquals("A", rule.getOutputs().get(0).getValue());
//    }

}

