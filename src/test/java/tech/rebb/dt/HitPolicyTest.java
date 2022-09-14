package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class HitPolicyTest {

    @Test
    public void testHitPolicyUniqueFail() throws RebbDTException {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input1 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity1 = new DecisionRuleInputEntry(inputGPA,">=3.5");
        input1.addEntry(inputEntity1);


        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutput output = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntry = new DecisionRuleOutputEntry(outputRank, "A");
        output.addEntry(outputEntry);

        DecisionRule rule1 = new DecisionRule(input1, output);

        DecisionRuleInput input2 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity2 = new DecisionRuleInputEntry(inputGPA,">3.0 and <=3.5");
        input2.addEntry(inputEntity2);

        DecisionRuleOutput output2 = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntity2 = new DecisionRuleOutputEntry(outputRank, "B");
        output2.addEntry(outputEntity2);

        DecisionRule rule2 = new DecisionRule(input2, output2);

        DecisionTable dt = new DecisionTable("Test Decision Table", 3.5);
        dt.addRule(rule1);
        dt.addRule(rule2);

        dt.run();

        assertTrue(dt.hasError());
        assertEquals("More than one rule matched while hit policy is unique", dt.getErrors().get(0));
        assertNull(dt.getOutput());
    }

    @Test
    public void testHitPolicyFirstFail() throws RebbDTException {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input1 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity1 = new DecisionRuleInputEntry(inputGPA,">=3.5");
        input1.addEntry(inputEntity1);


        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutput output = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntry = new DecisionRuleOutputEntry(outputRank, "A");
        output.addEntry(outputEntry);

        DecisionRule rule1 = new DecisionRule(input1, output);
        rule1.setNo(2);

        DecisionRuleInput input2 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity2 = new DecisionRuleInputEntry(inputGPA,">3.0 and <=3.5");
        input2.addEntry(inputEntity2);

        DecisionRuleOutput output2 = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntity2 = new DecisionRuleOutputEntry(outputRank, "B");
        output2.addEntry(outputEntity2);

        DecisionRule rule2 = new DecisionRule(input2, output2);

        DecisionTable dt = new DecisionTable("Test Decision Table", 3.5);
        dt.setHitPolicy(HitPolicy.FIRST);
        dt.addRule(rule1);
        dt.addRule(rule2);

        dt.run();

        assertTrue(dt.hasError());
        assertNull(dt.getOutput());
    }

    @Test
    public void testHitPolicyFirstSuccess() throws RebbDTException {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input1 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity1 = new DecisionRuleInputEntry(inputGPA,">=3.5");
        input1.addEntry(inputEntity1);


        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutput output = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntry = new DecisionRuleOutputEntry(outputRank, "A");
        output.addEntry(outputEntry);

        DecisionRule rule1 = new DecisionRule(input1, output);
        rule1.setNo(2);

        DecisionRuleInput input2 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity2 = new DecisionRuleInputEntry(inputGPA,">3.0 and <=3.5");
        input2.addEntry(inputEntity2);

        DecisionRuleOutput output2 = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntity2 = new DecisionRuleOutputEntry(outputRank, "B");
        output2.addEntry(outputEntity2);

        DecisionRule rule2 = new DecisionRule(input2, output2);
        rule2.setNo(1);

        DecisionTable dt = new DecisionTable("Test Decision Table", 3.5);
        dt.setHitPolicy(HitPolicy.FIRST);
        dt.addRule(rule1);
        dt.addRule(rule2);

        dt.run();

        assertFalse(dt.hasError());
        assertNotNull(dt.getOutput());

        assertEquals(1, dt.getOutput().size());
        assertEquals("B", dt.getOutput().get("Result"));
    }

    @Test
    public void testHitPolicyAnyFail() throws RebbDTException {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input1 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity1 = new DecisionRuleInputEntry(inputGPA,">=3.5");
        input1.addEntry(inputEntity1);


        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutput output = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntry = new DecisionRuleOutputEntry(outputRank, "A");
        output.addEntry(outputEntry);

        DecisionRule rule1 = new DecisionRule(input1, output);

        DecisionRuleInput input2 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity2 = new DecisionRuleInputEntry(inputGPA,">3.0 and <=3.5");
        input2.addEntry(inputEntity2);

        DecisionRuleOutput output2 = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntity2 = new DecisionRuleOutputEntry(outputRank, "B");
        output2.addEntry(outputEntity2);

        DecisionRule rule2 = new DecisionRule(input2, output2);

        DecisionTable dt = new DecisionTable("Test Decision Table", 3.5);
        dt.setHitPolicy(HitPolicy.ANY);
        dt.addRule(rule1);
        dt.addRule(rule2);

        dt.run();

        assertTrue(dt.hasError());
        assertEquals("More than one rule with different output matched while hit policy is any", dt.getErrors().get(0));
        assertNull(dt.getOutput());
    }

    @Test
    public void testHitPolicyAnySuccess() throws RebbDTException {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input1 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity1 = new DecisionRuleInputEntry(inputGPA,">=3.5");
        input1.addEntry(inputEntity1);


        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutput output = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntry = new DecisionRuleOutputEntry(outputRank, "A");
        output.addEntry(outputEntry);

        DecisionRule rule1 = new DecisionRule(input1, output);

        DecisionRuleInput input2 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity2 = new DecisionRuleInputEntry(inputGPA,">3.0 and <=3.5");
        input2.addEntry(inputEntity2);

        DecisionRuleOutput output2 = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntity2 = new DecisionRuleOutputEntry(outputRank, "A");
        output2.addEntry(outputEntity2);

        DecisionRule rule2 = new DecisionRule(input2, output2);

        DecisionTable dt = new DecisionTable("Test Decision Table", 3.5);
        dt.setHitPolicy(HitPolicy.ANY);
        dt.addRule(rule1);
        dt.addRule(rule2);

        dt.run();

        assertFalse(dt.hasError());
        assertNotNull(dt.getOutput());

        assertEquals(1, dt.getOutput().size());
        assertEquals("A", dt.getOutput().get("Result"));
    }

    @Test
    public void testHitPolicyPriorityFail() throws RebbDTException {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input1 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity1 = new DecisionRuleInputEntry(inputGPA,">=3.5");
        input1.addEntry(inputEntity1);


        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutput output = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntry = new DecisionRuleOutputEntry(outputRank, "A");
        output.addEntry(outputEntry);

        DecisionRule rule1 = new DecisionRule(input1, output);

        DecisionRuleInput input2 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity2 = new DecisionRuleInputEntry(inputGPA,">3.0 and <=3.5");
        input2.addEntry(inputEntity2);

        DecisionRuleOutput output2 = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntity2 = new DecisionRuleOutputEntry(outputRank, "A");
        output2.addEntry(outputEntity2);

        DecisionRule rule2 = new DecisionRule(input2, output2);

        DecisionTable dt = new DecisionTable("Test Decision Table", 3.5);
        dt.setHitPolicy(HitPolicy.PRIORITY);
        dt.addRule(rule1);
        dt.addRule(rule2);

        dt.run();

        assertTrue(dt.hasError());
        assertEquals("There is no allowed values in any output clause while hit policy is priority or output order", dt.getErrors().get(0));

        assertNull(dt.getOutput());
    }

    @Test
    public void testHitPolicyPrioritySuccess() throws RebbDTException {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input1 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity1 = new DecisionRuleInputEntry(inputGPA,">=3.5");
        input1.addEntry(inputEntity1);

        ArrayList<String> allowedListRank = new ArrayList<>();
        allowedListRank.add("A");
        allowedListRank.add("B");
        allowedListRank.add("C");

        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING,allowedListRank);
        DecisionRuleOutput output = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntry = new DecisionRuleOutputEntry(outputRank, "A");
        output.addEntry(outputEntry);

        DecisionRule rule1 = new DecisionRule(input1, output);

        DecisionRuleInput input2 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity2 = new DecisionRuleInputEntry(inputGPA,">3.0 and <=3.5");
        input2.addEntry(inputEntity2);

        DecisionRuleOutput output2 = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntity2 = new DecisionRuleOutputEntry(outputRank, "A");
        output2.addEntry(outputEntity2);

        DecisionRule rule2 = new DecisionRule(input2, output2);

        DecisionTable dt = new DecisionTable("Test Decision Table", 3.5);
        dt.setHitPolicy(HitPolicy.PRIORITY);
        dt.addRule(rule1);
        dt.addRule(rule2);

        dt.run();

        assertFalse(dt.hasError());

        assertNotNull(dt.getOutput());

        assertEquals(1, dt.getOutput().size());
        assertEquals("A", dt.getOutput().get("Result"));
    }

    @Test
    public void testHitPolicyCollectOutputNumberCheck() throws RebbDTException {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input1 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity1 = new DecisionRuleInputEntry(inputGPA,">3.5");
        input1.addEntry(inputEntity1);

        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutputClause outputScore = new DecisionRuleOutputClause("Score","",DecisionRuleOutputType.NUMBER);

        DecisionRuleOutput output = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntryRank = new DecisionRuleOutputEntry(outputRank, "A");
        DecisionRuleOutputEntry outputEntryScore = new DecisionRuleOutputEntry(outputScore, 10);
        output.addEntry(outputEntryRank);
        output.addEntry(outputEntryScore);

        DecisionRule rule1 = new DecisionRule(input1, output);

        DecisionRuleInput input2 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity2 = new DecisionRuleInputEntry(inputGPA,">3.0 and <=3.5");
        input2.addEntry(inputEntity2);

        DecisionRuleOutput output2 = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntryRank2 = new DecisionRuleOutputEntry(outputRank, "B");
        DecisionRuleOutputEntry outputEntryScore2 = new DecisionRuleOutputEntry(outputScore, 8);
        output2.addEntry(outputEntryRank2);
        output2.addEntry(outputEntryScore2);

        DecisionRule rule2 = new DecisionRule(input2, output2);

        DecisionTable dt = new DecisionTable("Test Decision Table", 3.1);
        dt.setHitPolicy(HitPolicy.COLLECT);
        dt.addRule(rule1);
        dt.addRule(rule2);

        dt.run();

        assertTrue(dt.hasError());
        assertEquals("The decision table should have single output while hit policy is collect", dt.getErrors().get(0));

        assertNull(dt.getOutput());
    }

    @Test
    public void testHitPolicyCollectAggregationCheck() throws RebbDTException {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input1 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity1 = new DecisionRuleInputEntry(inputGPA,">3.5");
        input1.addEntry(inputEntity1);

        DecisionRuleOutputClause outputScore = new DecisionRuleOutputClause("Score","",DecisionRuleOutputType.NUMBER);
        DecisionRuleOutput output = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntryScore = new DecisionRuleOutputEntry(outputScore, 10);
        output.addEntry(outputEntryScore);

        DecisionRule rule1 = new DecisionRule(input1, output);

        DecisionRuleInput input2 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity2 = new DecisionRuleInputEntry(inputGPA,">3.0 and <=3.5");
        input2.addEntry(inputEntity2);

        DecisionRuleOutput output2 = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntryScore2 = new DecisionRuleOutputEntry(outputScore, 8);
        output2.addEntry(outputEntryScore2);

        DecisionRule rule2 = new DecisionRule(input2, output2);

        DecisionTable dt = new DecisionTable("Test Decision Table", 3.1);
        dt.setHitPolicy(HitPolicy.COLLECT);
        dt.addRule(rule1);
        dt.addRule(rule2);

        dt.run();

        assertTrue(dt.hasError());
        assertEquals("The aggregation of decision table should not be NA while hit policy is collect", dt.getErrors().get(0));

        assertNull(dt.getOutput());
    }

    @Test
    public void testHitPolicyCollectOutputTypeCheck() throws RebbDTException {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input1 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity1 = new DecisionRuleInputEntry(inputGPA,">3.5");
        input1.addEntry(inputEntity1);

        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);

        DecisionRuleOutput output = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntryRank = new DecisionRuleOutputEntry(outputRank, "A");
        output.addEntry(outputEntryRank);

        DecisionRule rule1 = new DecisionRule(input1, output);

        DecisionRuleInput input2 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity2 = new DecisionRuleInputEntry(inputGPA,">3.0");
        input2.addEntry(inputEntity2);

        DecisionRuleOutput output2 = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntryRank2 = new DecisionRuleOutputEntry(outputRank, "B");
        output2.addEntry(outputEntryRank2);

        DecisionRule rule2 = new DecisionRule(input2, output2);

        DecisionTable dt = new DecisionTable("Test Decision Table", 3.7);
        dt.setHitPolicy(HitPolicy.COLLECT);
        dt.setAggregation(BuildInAggregation.COUNT);
        dt.addRule(rule1);
        dt.addRule(rule2);
        dt.run();

        assertFalse(dt.hasError());
        assertNotNull(dt.getOutput());
        assertEquals(1, dt.getOutput().size());
        assertEquals(2, ((Integer)dt.getOutput().get("Result")).intValue());

        dt.setAggregation(BuildInAggregation.MIN);
        dt.run();

        assertTrue(dt.hasError());
        assertEquals("The output type should be number while hit policy is 'collect' and aggregation is not 'count'", dt.getErrors().get(0));
        assertNull(dt.getOutput());

        dt.setAggregation(BuildInAggregation.MAX);
        dt.run();

        assertTrue(dt.hasError());
        assertEquals("The output type should be number while hit policy is 'collect' and aggregation is not 'count'", dt.getErrors().get(0));
        assertNull(dt.getOutput());

        dt.setAggregation(BuildInAggregation.SUM);
        dt.run();

        assertTrue(dt.hasError());
        assertEquals("The output type should be number while hit policy is 'collect' and aggregation is not 'count'", dt.getErrors().get(0));
        assertNull(dt.getOutput());

    }

    @Test
    public void testHitPolicyCollectSuccess() throws RebbDTException {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input1 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity1 = new DecisionRuleInputEntry(inputGPA,">3.5");
        input1.addEntry(inputEntity1);

        DecisionRuleOutputClause outputScore = new DecisionRuleOutputClause("Score","",DecisionRuleOutputType.NUMBER);
        DecisionRuleOutput output = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntryScore = new DecisionRuleOutputEntry(outputScore, 10);
        output.addEntry(outputEntryScore);

        DecisionRule rule1 = new DecisionRule(input1, output);

        DecisionRuleInput input2 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity2 = new DecisionRuleInputEntry(inputGPA,">3.0");
        input2.addEntry(inputEntity2);

        DecisionRuleOutput output2 = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntryScore2 = new DecisionRuleOutputEntry(outputScore, 8);
        output2.addEntry(outputEntryScore2);

        DecisionRule rule2 = new DecisionRule(input2, output2);

        DecisionTable dt = new DecisionTable("Test Decision Table", 3.8);
        dt.setHitPolicy(HitPolicy.COLLECT);
        dt.setAggregation(BuildInAggregation.MAX);
        dt.addRule(rule1);
        dt.addRule(rule2);

        dt.run();

        assertFalse(dt.hasError());

        assertNotNull(dt.getOutput());

        assertEquals(1, dt.getOutput().size());
        assertEquals(10, ((Double)dt.getOutput().get("Result")).intValue());

        dt.setAggregation(BuildInAggregation.MIN);
        dt.run();
        assertFalse(dt.hasError());

        assertNotNull(dt.getOutput());

        assertEquals(1, dt.getOutput().size());
        assertEquals(8, ((Double)dt.getOutput().get("Result")).intValue());

        dt.setAggregation(BuildInAggregation.SUM);
        dt.run();
        assertFalse(dt.hasError());

        assertNotNull(dt.getOutput());

        assertEquals(1, dt.getOutput().size());
        assertEquals(18, ((Double)dt.getOutput().get("Result")).intValue());

        dt.setAggregation(BuildInAggregation.COUNT);
        dt.run();
        assertFalse(dt.hasError());

        assertNotNull(dt.getOutput());

        assertEquals(1, dt.getOutput().size());
        assertEquals(2, ((Integer)dt.getOutput().get("Result")).intValue());
    }

    @Test
    public void testHitPolicyRuleOrder() throws RebbDTException {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input1 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity1 = new DecisionRuleInputEntry(inputGPA,">3.5");
        input1.addEntry(inputEntity1);

        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutputClause outputScore = new DecisionRuleOutputClause("Score","",DecisionRuleOutputType.NUMBER);

        DecisionRuleOutput output = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntryRank = new DecisionRuleOutputEntry(outputRank, "A");
        DecisionRuleOutputEntry outputEntryScore = new DecisionRuleOutputEntry(outputScore, 10);
        output.addEntry(outputEntryRank);
        output.addEntry(outputEntryScore);

        DecisionRule rule1 = new DecisionRule(input1, output);
        rule1.setNo(2);

        DecisionRuleInput input2 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity2 = new DecisionRuleInputEntry(inputGPA,">3.0");
        input2.addEntry(inputEntity2);

        DecisionRuleOutput output2 = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntryRank2 = new DecisionRuleOutputEntry(outputRank, "B");
        DecisionRuleOutputEntry outputEntryScore2 = new DecisionRuleOutputEntry(outputScore, 8);
        output2.addEntry(outputEntryRank2);
        output2.addEntry(outputEntryScore2);

        DecisionRule rule2 = new DecisionRule(input2, output2);
        rule2.setNo(1);

        DecisionTable dt = new DecisionTable("Test Decision Table", 3.6);
        dt.setHitPolicy(HitPolicy.RULE_ORDER);
        dt.addRule(rule1);
        dt.addRule(rule2);

        dt.run();

        assertFalse(dt.hasError());
        assertEquals(1, dt.getOutput().size());
        assertTrue(dt.getOutput().get("Result") instanceof ArrayList);
        assertEquals(2, ((ArrayList)dt.getOutput().get("Result")).size());

        Map<String,Object> result0 = (Map<String,Object>)((ArrayList)dt.getOutput().get("Result")).get(0);
        assertEquals("B", result0.get("Rank"));
        assertEquals(8, result0.get("Score"));

        Map<String,Object> result1 = (Map<String,Object>)((ArrayList)dt.getOutput().get("Result")).get(1);
        assertEquals("A", result1.get("Rank"));
        assertEquals(10, result1.get("Score"));
    }

    @Test
    public void testHitPolicyOutputOrder() throws RebbDTException {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input1 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity1 = new DecisionRuleInputEntry(inputGPA,">3.5");
        input1.addEntry(inputEntity1);

        ArrayList<String> allowedListRank = new ArrayList<>();
        allowedListRank.add("C");
        allowedListRank.add("B");
        allowedListRank.add("A");

        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING, allowedListRank);
        DecisionRuleOutputClause outputScore = new DecisionRuleOutputClause("Score","",DecisionRuleOutputType.NUMBER);

        DecisionRuleOutput output = new DecisionRuleOutput();

        DecisionRuleOutputEntry outputEntryRank = new DecisionRuleOutputEntry(outputRank, "A");
        DecisionRuleOutputEntry outputEntryScore = new DecisionRuleOutputEntry(outputScore, 10);
        output.addEntry(outputEntryRank);
        output.addEntry(outputEntryScore);

        DecisionRule rule1 = new DecisionRule(input1, output);
        rule1.setNo(1);

        DecisionRuleInput input2 = new DecisionRuleInput();
        DecisionRuleInputEntry inputEntity2 = new DecisionRuleInputEntry(inputGPA,">3.0");
        input2.addEntry(inputEntity2);

        DecisionRuleOutput output2 = new DecisionRuleOutput();
        DecisionRuleOutputEntry outputEntryRank2 = new DecisionRuleOutputEntry(outputRank, "B");
        DecisionRuleOutputEntry outputEntryScore2 = new DecisionRuleOutputEntry(outputScore, 8);
        output2.addEntry(outputEntryRank2);
        output2.addEntry(outputEntryScore2);

        DecisionRule rule2 = new DecisionRule(input2, output2);
        rule2.setNo(2);

        DecisionTable dt = new DecisionTable("Test Decision Table", 3.6);
        dt.setHitPolicy(HitPolicy.OUTPUT_ORDER);
        dt.addRule(rule1);
        dt.addRule(rule2);

        dt.run();

        assertFalse(dt.hasError());
        assertEquals(1, dt.getOutput().size());
        assertTrue(dt.getOutput().get("Result") instanceof ArrayList);
        assertEquals(2, ((ArrayList)dt.getOutput().get("Result")).size());

        Map<String,Object> result0 = (Map<String,Object>)((ArrayList)dt.getOutput().get("Result")).get(0);
        assertEquals("B", result0.get("Rank"));
        assertEquals(8, result0.get("Score"));

        Map<String,Object> result1 = (Map<String,Object>)((ArrayList)dt.getOutput().get("Result")).get(1);
        assertEquals("A", result1.get("Rank"));
        assertEquals(10, result1.get("Score"));
    }
}

