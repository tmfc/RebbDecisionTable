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

    public void addEntry(DecisionRuleAnnotationEntry entry) {
        this.entries.add(entry);
    }
}
