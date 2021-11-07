package tech.rebb.dt;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DecisionRuleAnnotationClause {
    private final String name;

    public String getName() {
        return name;
    }

    private final String signature;

    public String getSignature() {
        return signature;
    }

    public DecisionRuleAnnotationClause(String name) {
        this.name = name;

        this.signature = Helper.sign(this.name);
    }
}
