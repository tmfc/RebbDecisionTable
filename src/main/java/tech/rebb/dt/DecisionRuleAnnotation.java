package tech.rebb.dt;

import java.util.ArrayList;
import java.util.List;

public class DecisionRuleAnnotation {

    private final List<DecisionRuleAnnotationEntry> entries;

    public List<DecisionRuleAnnotationEntry> getEntries() {
        return entries;
    }

    public DecisionRuleAnnotation() {
        this.entries = new ArrayList<>();
    }

    public boolean addEntry(DecisionRuleAnnotationEntry entry) {

        // Check duplicated entry
        for (DecisionRuleAnnotationEntry e:
                this.entries) {
            if(e.getSignature().equals(entry.getSignature()))
                return false;
        }
        return this.entries.add(entry);
    }
}
