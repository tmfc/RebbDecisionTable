package tech.rebb.dt;

import apple.laf.JRSUIConstants;

import java.util.List;

public class DecisionTable {

    private String name;

    public String getName() {
        return name;
    }

    private HitPolicy hitPolicy;

    public HitPolicy getHitPolicy() {
        return hitPolicy;
    }

    public void setHitPolicy(HitPolicy hitPolicy) {
        this.hitPolicy = hitPolicy;
    }

    private int aggregation;

    public int getAggregation() {
        return aggregation;
    }

    public void setAggregation(int aggregation) {
        this.aggregation = aggregation;
    }

    private List<DecisionRule> rules;

    public List<DecisionRule> getRules() {
        return rules;
    }

    public void setRules(List<DecisionRule> rules) {
        this.rules = rules;
    }

    public void addRule(DecisionRule rule)
    {
        this.rules.add(rule);
    }

    private String outputLabel;

    public String getOutputLabel() {
        return outputLabel;
    }

    public void setOutputLabel(String outputLabel) {
        this.outputLabel = outputLabel;
    }


}
