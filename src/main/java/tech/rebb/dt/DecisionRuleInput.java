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
        // Check duplicated entry
        for (DecisionRuleInputEntry e:
             this.entries) {
            if(e.getSignature().equals(entry.getSignature()))
                return false;
        }

        return this.entries.add(entry);
    }
}
