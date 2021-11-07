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

    public boolean addEntry(DecisionRuleInputEntry entry) {
        return this.entries.add(entry);
    }
}
