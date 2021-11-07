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
        String hash = null;
        String strToHash = this.name;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(strToHash.getBytes());
            byte[] digest = md.digest();
            hash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            hash = strToHash;
        }
        this.signature = hash;
    }
}
