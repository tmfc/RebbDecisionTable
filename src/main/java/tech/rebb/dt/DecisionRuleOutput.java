package tech.rebb.dt;

import java.util.ArrayList;
import java.util.List;

public class DecisionRuleOutput {

    private final List<DecisionRuleOutputEntry> entries;

    public List<DecisionRuleOutputEntry> getEntries() {
        return entries;
    }

    public DecisionRuleOutput() {
        this.entries = new ArrayList<>();
    }

    public void addEntry(DecisionRuleOutputEntry entry) {
        this.entries.add(entry);
    }
}
