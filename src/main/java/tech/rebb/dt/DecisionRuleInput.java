package tech.rebb.dt;

import java.util.ArrayList;
import java.util.List;

public class DecisionRuleInput {

    private final List<DecisionRuleInputEntry> entries;

    public List<DecisionRuleInputEntry> getEntries() {
        return entries;
    }

    public DecisionRuleInput() {
        this.entries = new ArrayList<>();
    }

    public void addEntry(DecisionRuleInputEntry entry) {
        this.entries.add(entry);
    }
}
