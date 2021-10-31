package tech.rebb.dt;

import java.util.ArrayList;
import java.util.List;

public class DecisionRuleOutput {

    private final String label;

    public String getLabel() {
        return label;
    }

    private final List<DecisionRuleOutputEntry> entries;

    public List<DecisionRuleOutputEntry> getEntries() {
        return entries;
    }

    public DecisionRuleOutput(String label) {
        this.label = label;
        this.entries = new ArrayList<>();
    }

    public void addEntity(DecisionRuleOutputEntry entry) {
        this.entries.add(entry);
    }
}
