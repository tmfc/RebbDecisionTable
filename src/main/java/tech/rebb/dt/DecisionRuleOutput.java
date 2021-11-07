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

    public boolean addEntry(DecisionRuleOutputEntry entry) {
        // Check duplicated entry
        for (DecisionRuleOutputEntry e:
                this.entries) {
            if(e.getSignature().equals(entry.getSignature()))
                return false;
        }
        return  this.entries.add(entry);
    }
}
