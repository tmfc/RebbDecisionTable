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
        if(entry == null)
            return false;

        for (DecisionRuleOutputEntry e:
                this.entries) {

            // Check clause is same
            if(e.getClause() != null
                    && e.getClause().getSignature().equals(entry.getClause().getSignature()))
                return false;
        }
        return  this.entries.add(entry);
    }
}
