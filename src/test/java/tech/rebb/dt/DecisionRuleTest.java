package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DecisionRuleTest {

    @Test
    public void testConstructor()
    {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input = new DecisionRuleInput(1, inputGPA,">3.5");

        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutput output = new DecisionRuleOutput(outputRank);

        ArrayList<DecisionRuleInput> inputs = new ArrayList<>();
        ArrayList<DecisionRuleOutput> outputs = new ArrayList<>();

        inputs.add(input);
        outputs.add(output);

        DecisionRule rule = new DecisionRule(3.6, inputs, outputs);

        assertEquals(3.6, rule.getObj());
        assertEquals(1, rule.getInputs().size());
        assertEquals(1, rule.getOutputs().size());
    }

    @Test
    public void testSingleInputOutput()
    {
        DecisionRuleInputClause inputGPA = new DecisionRuleInputClause("GPA","gpa");
        DecisionRuleInput input = new DecisionRuleInput(1, inputGPA,">3.5");

        DecisionRuleOutputClause outputRank = new DecisionRuleOutputClause("Rank","",DecisionRuleOutputType.STRING);
        DecisionRuleOutput output = new DecisionRuleOutput(outputRank);
        ArrayList<DecisionRuleInput> inputs = new ArrayList<>();
        ArrayList<DecisionRuleOutput> outputs = new ArrayList<>();

        inputs.add(input);
        outputs.add(output);

        DecisionRule rule = new DecisionRule(3.6, inputs, outputs);

        boolean result = rule.evaluate();
        assertTrue(result);
    }

}

