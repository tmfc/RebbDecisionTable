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
        if(entry == null)
            return false;
        for (DecisionRuleAnnotationEntry e:
                this.entries) {
            // Check duplicated clause
            if(e.getClause() != null
                    && e.getClause().getSignature().equals(entry.getClause().getSignature()))
                return false;
        }
        return this.entries.add(entry);
    }

    public String getSignature() {
        StringBuilder strToHash = new StringBuilder();
        for (DecisionRuleAnnotationEntry e:
                this.entries) {
            strToHash.append(e.getSignature());
        }

        return Helper.sign(strToHash.toString());
    }
}
