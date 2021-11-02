package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;

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
        DecisionRuleOutput output = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntry = new DecisionRuleOutputEntry(outputRank, "A");
        output.addEntry(outputEntry);


        ArrayList<DecisionRuleInput> inputs = new ArrayList<>();

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
        DecisionRuleOutput output = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntry = new DecisionRuleOutputEntry(outputRank, "A");
        output.addEntry(outputEntry);

        ArrayList<DecisionRuleInput> inputs = new ArrayList<>();

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
        DecisionRuleOutput output = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntry = new DecisionRuleOutputEntry(outputRank, "A");
        output.addEntry(outputEntry);

        ArrayList<DecisionRuleInput> inputs = new ArrayList<>();

        inputs.add(input1);

        DecisionRule rule1 = new DecisionRule(inputs, output);

        DecisionRuleInput input2 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity2 = new DecisionRuleInputEntry(inputGPA,">3.0");
        input2.addEntity(inputEntity2);

        DecisionRuleOutput output2 = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntity2 = new DecisionRuleOutputEntry(outputRank, "B");
        output2.addEntry(outputEntity2);

        inputs = new ArrayList<>();

        inputs.add(input2);

        DecisionRule rule2 = new DecisionRule(inputs, output2);

        DecisionTable dt = new DecisionTable("Test Decision Table", 3.1);
        dt.addRule(rule1);
        dt.addRule(rule2);

        dt.run();

        assertFalse(dt.hasError());
        assertEquals(1, dt.getOutput().size());
        assertEquals("B", dt.getOutput().get("Result"));
    }


    @Test
    public void testMultipleOutputEntity()
    {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input1 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity1 = new DecisionRuleInputEntry(inputGPA,">3.5");
        input1.addEntity(inputEntity1);

        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutputClause outputScore = new DecisionRuleOutputClause("Score","",DecisionRuleOutputType.NUMBER);

        DecisionRuleOutput output = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntryRank = new DecisionRuleOutputEntry(outputRank, "A");
        DecisionRuleOutputEntry outputEntryScore = new DecisionRuleOutputEntry(outputScore, 10);
        output.addEntry(outputEntryRank);
        output.addEntry(outputEntryScore);

        ArrayList<DecisionRuleInput> inputs = new ArrayList<>();

        inputs.add(input1);

        DecisionRule rule1 = new DecisionRule(inputs, output);

        DecisionRuleInput input2 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity2 = new DecisionRuleInputEntry(inputGPA,">3.0");
        input2.addEntity(inputEntity2);

        DecisionRuleOutput output2 = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntryRank2 = new DecisionRuleOutputEntry(outputRank, "B");
        DecisionRuleOutputEntry outputEntryScore2 = new DecisionRuleOutputEntry(outputRank, 8);
        output2.addEntry(outputEntryRank2);
        output2.addEntry(outputEntryScore2);

        inputs = new ArrayList<>();

        inputs.add(input2);

        DecisionRule rule2 = new DecisionRule(inputs, output);

        DecisionTable dt = new DecisionTable("Test Decision Table", 3.1);
        dt.addRule(rule1);
        dt.addRule(rule2);

        dt.run();

        assertFalse(dt.hasError());
        assertEquals(1, dt.getOutput().size());
        assertTrue(dt.getOutput().get("Result") instanceof Map);
        assertEquals("A", ((Map<String, Object>)dt.getOutput().get("Result")).get("Rank"));
        assertEquals(10, ((Map<String, Object>)dt.getOutput().get("Result")).get("Score"));
    }


}
