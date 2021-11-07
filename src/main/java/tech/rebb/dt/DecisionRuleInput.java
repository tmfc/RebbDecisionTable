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
        if(entry == null)
            return false;

        for (DecisionRuleInputEntry e:
             this.entries) {
            // Check duplicated clause
            if(e.getClause() != null
                    && e.getClause().getSignature().equals(entry.getClause().getSignature()))
                return false;
        }

        return this.entries.add(entry);
    }
}
