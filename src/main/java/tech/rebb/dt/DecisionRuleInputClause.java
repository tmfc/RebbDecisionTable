package tech.rebb.dt;


import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Collections;

public class DecisionRuleInputClause {

    private final String name;

    public String getName() {
        return name;
    }

    private final String expression;

    public String getExpression() {
        return expression;
    }

    private final List<String> allowedValues;

    public List<String> getAllowedValues() {
        return allowedValues;
    }

    private final String signature;

    public String getSignature() {
        return signature;
    }

    public DecisionRuleInputClause(String name, String expression) {
        this(name, expression, null);
    }

    public DecisionRuleInputClause(String name, String expression, List<String> allowedValues) {
        this.name = name;
        this.expression = expression;
        this.allowedValues = allowedValues;

        String hash = null;
        String strToHash = this.name + this.expression;
        if(this.allowedValues != null)
            strToHash = this.name + this.expression + this.allowedValues.toString();

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
