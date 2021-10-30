package tech.rebb.dt;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DecisionRuleTest {

    @Test
    public void testConstructor()
    {
        DecisionRuleInput input = new DecisionRuleInput(1,3.6,">3.5");

        DecisionRuleOutput output = new DecisionRuleOutput("label","",DecisionRuleOutputType.BOOLEAN);

        ArrayList<DecisionRuleInput> inputs = new ArrayList<>();
        ArrayList<DecisionRuleOutput> outputs = new ArrayList<>();

        inputs.add(input);
        outputs.add(output);

        DecisionRule rule = new DecisionRule(inputs, outputs);

        assertEquals(1, rule.getInputs().size());
        assertEquals(1, rule.getOutputs().size());
    }

    @Test
    public void testSingleInputOutput()
    {
        DecisionRuleInput input = new DecisionRuleInput(1,3.6,">3.5");

        DecisionRuleOutput output = new DecisionRuleOutput("label","",DecisionRuleOutputType.BOOLEAN);

        ArrayList<DecisionRuleInput> inputs = new ArrayList<>();
        ArrayList<DecisionRuleOutput> outputs = new ArrayList<>();

        inputs.add(input);
        outputs.add(output);

        DecisionRule rule = new DecisionRule(inputs, outputs);

        boolean result = rule.evaluate();
        assertTrue(result);
    }
}

