package tech.rebb.dt;

import java.util.ArrayList;

public class DecisionTable {

    private int hitPolicy;

    public int getHitPolicy() {
        return hitPolicy;
    }

    public void setHitPolicy(int hitPolicy) {
        this.hitPolicy = hitPolicy;
    }

    private int aggregation;

    public int getAggregation() {
        return aggregation;
    }

    public void setAggregation(int aggregation) {
        this.aggregation = aggregation;
    }

    private ArrayList<DecisionRule> rules;


    public ArrayList<DecisionRule> getRules() {
        return rules;
    }

    public void setRules(ArrayList<DecisionRule> rules) {
        this.rules = rules;
    }

    public void addRule(DecisionRule rule)
    {
        this.rules.add(rule);
    }

    private ArrayList<String> outputLabel;

    public ArrayList<String> getOutputLabel() {
        return outputLabel;
    }

    public void setOutputLabel(ArrayList<String> outputLabel) {
        this.outputLabel = outputLabel;
    }

    private ArrayList<DecisionRuleOutput> outputs;

    public ArrayList<DecisionRuleOutput> getOutputs() {
        return outputs;
    }


}
