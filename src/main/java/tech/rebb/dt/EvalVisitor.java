package tech.rebb.dt;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvalVisitor extends RebbDTBaseVisitor<Void> {
    ParseTreeProperty<Object> values = new ParseTreeProperty<Object>();

    Map<String, Class> customFunctions = new HashMap<>();
    HashMap<Integer, Object> config = new HashMap<>();

    private Locale timezone;

    private Object obj;

    private String error;
    private boolean valid;
    private final String ObjectTypeNotSupported = "Object type not supported";
    private final String ObjectTypeNotBoolean = "Object is not a boolean";
    private final String ObjectTypeNotDate = "Object is not a Date";
    private final String ObjectTypeNotString = "Object is not a String";
    private final String ExpressionValueTypeNotMatch = "Expression value type not match";

    public EvalVisitor(Object obj, HashMap<Integer,Object> global_config)
    {
        setTimezone(Locale.CHINA);
        this.setObject(obj);
        this.initConfig(global_config);
    }

    public void setObject(Object obj)
    {
        this.valid = false;
        this.error = "";

        if(obj instanceof Double)
            this.obj = BigDecimal.valueOf((Double)obj);
        else if(obj instanceof Float)
            this.obj = BigDecimal.valueOf((Float)obj);
        else if(obj instanceof Long)
            this.obj = BigDecimal.valueOf((Long)obj);
        else if(obj instanceof Integer)
            this.obj = BigDecimal.valueOf((Integer)obj);
        else if(obj instanceof Date)
            this.obj = obj;
        else if(obj instanceof Boolean)
            this.obj = obj;
        else if(obj instanceof String)
            this.obj = obj;
        else {
            this.obj = obj;
            this.valid = false;
            this.error = ObjectTypeNotSupported;
        }
    }

    private void initConfig(HashMap<Integer,Object> global_config)
    {
        if(global_config != null)
        {
            this.config = (HashMap<Integer, Object>) global_config.clone();
        }
        else
            this.config = new HashMap<Integer, Object>();
        if(!this.config.containsKey(RebbDTConfig.TRUE_STRING))
        {
            String[] trueStringDefault = new String[] {"true","on", "1", "yes","ok"};
//            ArrayList<String> trueStringListDefault = new ArrayList<>(Arrays.asList(trueStringDefault));
            this.config.put(RebbDTConfig.TRUE_STRING, trueStringDefault);
        }
    }

    public void addConfig(Integer key, Object value)
    {
        this.config.put(key, value);
    }

    public void setTimezone(Locale timezone)
    {
        this.timezone = timezone;
    }
    public Locale getTimezone()
    {
        return this.timezone;
    }

    public boolean isValid() {
        return valid;
    }
    public String getError() {
        return error;
    }

    private void setValue(ParseTree node, Object value) { values.put(node, value); }

    private Object getValue(ParseTree node) { return values.get(node); }

    public void registerCustomValidator(String name, Class clazz)
    {
        customFunctions.put(name, clazz);
    }

    //Unary Test and Combination begin
    @Override
    public Void visitConjunction(RebbDTParser.ConjunctionContext ctx) {
        RebbDTParser.UnaryTestsContext unaryCtx0 = ctx.unaryTests();
        RebbDTParser.UnaryTestContext unaryCtx1 = ctx.unaryTest();
        visit(unaryCtx0);
        visit(unaryCtx1);
        if(getValue(unaryCtx0) instanceof Boolean && getValue(unaryCtx1) instanceof Boolean)
        {
            boolean value0 = (Boolean)getValue(unaryCtx0);
            boolean value1 = (Boolean)getValue(unaryCtx1);
            setValue(ctx, value0 && value1);
            this.valid = value0 && value1;
        }
        else
        {
            setValue(ctx, false);
            this.valid = false;
            this.error = ExpressionValueTypeNotMatch;
        }
        return null;
    }

    @Override
    public Void visitDisjunction(RebbDTParser.DisjunctionContext ctx) {
        RebbDTParser.UnaryTestsContext unaryCtx0 = ctx.unaryTests();
        RebbDTParser.UnaryTestContext unaryCtx1 = ctx.unaryTest();
        visit(unaryCtx0);
        visit(unaryCtx1);
        if(getValue(unaryCtx0) instanceof Boolean && getValue(unaryCtx1) instanceof Boolean)
        {
            boolean value0 = (Boolean)getValue(unaryCtx0);
            boolean value1 = (Boolean)getValue(unaryCtx1);
            setValue(ctx, value0 || value1);
            this.valid = value0 || value1;
        }
        else
        {
            setValue(ctx, false);
            this.valid = false;
            this.error = ExpressionValueTypeNotMatch;
        }
        return null;
    }
    @Override
    public Void visitSingleTest(RebbDTParser.SingleTestContext ctx) {
        RebbDTParser.UnaryTestContext unaryCtx = ctx.unaryTest();
        visit(unaryCtx);

        if(getValue(unaryCtx) instanceof Boolean)
        {
            boolean value = (Boolean)getValue(unaryCtx);
            setValue(ctx, value);
            this.valid = value;
        }
        else
        {
            setValue(ctx, false);
            this.valid = false;
            this.error = ExpressionValueTypeNotMatch;
        }
        return null;
    }

    @Override
    public Void visitNormalUnaryTest(RebbDTParser.NormalUnaryTestContext ctx) {
        visit(ctx.positiveUnaryTest());
        setValue(ctx, getValue(ctx.positiveUnaryTest()));
        return null;
    }

    @Override
    public Void visitNegationUnaryTest(RebbDTParser.NegationUnaryTestContext ctx)
    {
        RebbDTParser.PositiveUnaryTestContext unaryTestCtx = ctx.positiveUnaryTest();
        visit(unaryTestCtx);
        if(getValue(unaryTestCtx) instanceof Boolean)
        {
            boolean value = (Boolean)getValue(unaryTestCtx);
            setValue(ctx, !value);
        }
        else
        {
            setValue(ctx, false);
            this.error = ExpressionValueTypeNotMatch;
        }

        return null;
    }

    @Override
    public Void visitIgnoreUnaryTest(RebbDTParser.IgnoreUnaryTestContext ctx) {
        setValue(ctx, true);
        return null;
    }

    @Override
    public Void visitPositiveUnaryTest(RebbDTParser.PositiveUnaryTestContext ctx) {
        visit(ctx.expression());
        setValue(ctx, getValue(ctx.expression()));
        return null;
    }
    //Unary Test and Combination end

    //Basic element start
    /** String */
    @Override
    public Void visitString(RebbDTParser.StringContext ctx) {
        String str = ctx.StringLiteral().getText();
        if(str != null)
            setValue(ctx, str.substring(1, str.length() -1));
        return null;
    }

    /** Number */
    @Override
    public Void visitNumber(RebbDTParser.NumberContext ctx) {
        try {
            setValue(ctx, new BigDecimal(ctx.NumbericLiteral().getText()));
        } catch(NumberFormatException e)
        {
            setValue(ctx, null);
            this.error = e.getMessage();
        }
        return null;
    }

    /** Date */
    @Override
    public Void visitDate(RebbDTParser.DateContext ctx) {
        try {
            Date date =new SimpleDateFormat("yyyy-MM-dd").parse(ctx.DateLiteral().getText());
            setValue(ctx, date);
        } catch (ParseException e) {
            setValue(ctx, null);
            this.error = e.getMessage();
        }
        return null;
    }

    /** Array */
    @Override
    public Void visitArray(RebbDTParser.ArrayContext ctx) {
        try {
            ArrayList<BigDecimal> array = new ArrayList<>();
            for(ParseTree tree:ctx.arrayLiteral().NumbericLiteral())
            {
                BigDecimal element = new BigDecimal(tree.getText());
                array.add(element);
            }
            setValue(ctx, array);
        } catch(NumberFormatException e)
        {
            setValue(ctx, null);
            this.error = e.getMessage();
        }
        return null;

    }
    //Basic element end

    @Override
    public Void visitBetween(RebbDTParser.BetweenContext ctx) {
        visit(ctx.expression(0));
        visit(ctx.expression(1));
        Object l_value = getValue(ctx.expression(0));
        Object r_value = getValue(ctx.expression(1));
        if(this.obj instanceof BigDecimal && l_value instanceof BigDecimal && r_value instanceof BigDecimal)
        {
            BigDecimal obj = (BigDecimal)this.obj;
            BigDecimal l = (BigDecimal)l_value;
            BigDecimal r = (BigDecimal)r_value;

            if(obj.compareTo(l) >= 0 && obj.compareTo(r) <= 0) {
                setValue(ctx, true);
            }
            else {
                setValue(ctx, false);
            }
        }
        else if(this.obj instanceof Date && l_value instanceof Date && r_value instanceof Date)
        {
            Date obj = (Date)this.obj;
            Date l = (Date)l_value;
            Date r = (Date)r_value;

            if(obj.compareTo(l) >= 0 && obj.compareTo(r) <= 0) {
                setValue(ctx, true);
            }
            else {
                setValue(ctx, false);
            }
        }
        else
        {
            setValue(ctx, false);
            this.error = ObjectTypeNotSupported;
        }
        return null;
    }

    @Override
    public Void visitIn(RebbDTParser.InContext ctx) {
        visit(ctx.expression());
        Object exprValue = getValue(ctx.expression());
        if(this.obj instanceof String && exprValue instanceof String)
        {
            String obj = (String)this.obj;
            String expr = (String)exprValue;
            setValue(ctx, expr.contains(obj));
        }
        else if(this.obj instanceof BigDecimal && exprValue instanceof ArrayList)
        {
            BigDecimal obj = (BigDecimal)this.obj;
            ArrayList<BigDecimal> array = (ArrayList<BigDecimal>)exprValue;
            setValue(ctx, array.contains(obj));
        }
        else
        {
            setValue(ctx, false);
            this.error = ObjectTypeNotSupported;
        }
        return null;
    }

    @Override
    public Void visitContains(RebbDTParser.ContainsContext ctx) {
        visit(ctx.expression());
        Object exprValue = getValue(ctx.expression());
        if (this.obj instanceof String && exprValue instanceof String) {
            String obj = (String) this.obj;
            String expr = (String) exprValue;
            if (obj.contains(expr))
                setValue(ctx, true);
            else
                setValue(ctx, false);
        } else {
            setValue(ctx, false);
            this.error = ObjectTypeNotSupported;
        }
        return null;
    }

    @Override
    public Void visitNotEmpty(RebbDTParser.NotEmptyContext ctx) {
        if(this.obj instanceof String)
            setValue(ctx, !this.obj.equals(""));
        else
        {
            setValue(ctx, false);
            this.error = ObjectTypeNotSupported;
        }
        return null;
    }

    @Override
    public Void visitMaxLength(RebbDTParser.MaxLengthContext ctx) {
        try {
            BigDecimal exprValue = new BigDecimal(ctx.NumbericLiteral().getText());
            if(this.obj instanceof String)
            {
                String obj = (String)this.obj;
                if(exprValue.compareTo(BigDecimal.valueOf(obj.length())) >= 0)
                    setValue(ctx, true);
                else
                    setValue(ctx, false);
            }
            else
            {
                setValue(ctx, false);
                this.error = ObjectTypeNotSupported;
            }
        } catch(NumberFormatException e)
        {
            setValue(ctx, null);
            this.error = e.getMessage();
        }
        return null;
    }

    @Override
    public Void visitInterval(RebbDTParser.IntervalContext ctx) {
        visit(ctx.expression(0));
        visit(ctx.expression(1));
        Object l_value = getValue(ctx.expression(0));
        Object r_value = getValue(ctx.expression(1));
        if(l_value instanceof BigDecimal && r_value instanceof BigDecimal && this.obj instanceof BigDecimal)
        {
            BigDecimal obj = (BigDecimal)this.obj;
            BigDecimal l = (BigDecimal)l_value;
            BigDecimal r = (BigDecimal)r_value;

            boolean result = doIntervalCompare(obj, l, r, ctx.start.getText(), ctx.end.getText());
            setValue(ctx, result);
        }
        else if(l_value instanceof Date && r_value instanceof Date && this.obj instanceof Date)
        {
            Date obj = (Date)this.obj;
            Date l = (Date)l_value;
            Date r = (Date)r_value;

            boolean result = doIntervalCompare(obj, l, r, ctx.start.getText(), ctx.end.getText());
            setValue(ctx, result);
        }
        else{
            setValue(ctx, false);
            this.error = ObjectTypeNotSupported;
        }
        return null;
    }

    private <T> boolean doIntervalCompare(Comparable<T> obj, T l, T r, String start,String end)
    {
        boolean startResult = false;
        boolean endResult = false;
        if(start.equals("(") || start.equals("]"))
            startResult = obj.compareTo(l) > 0;
        if(start.equals("["))
            startResult = obj.compareTo(l) >= 0;

        if(startResult){
            if(end.equals(")") || end.equals("["))
                endResult = obj.compareTo(r) < 0;
            if(end.equals("]"))
                endResult = obj.compareTo(r) <= 0;
        }

        return startResult && endResult;
    }

    @Override
    public Void visitCompare(RebbDTParser.CompareContext ctx) {
        boolean result = false;
        visit(ctx.expression());
        if(this.obj instanceof BigDecimal && getValue(ctx.expression()) instanceof BigDecimal)
        {
            BigDecimal obj = (BigDecimal)this.obj;
            BigDecimal exprValue = (BigDecimal)getValue(ctx.expression());
            result = doCompare(obj, exprValue, ctx.op.getType());
            setValue(ctx, result);
        }
        else if (this.obj instanceof Date && getValue(ctx.expression()) instanceof Date)
        {
            Date obj = (Date)this.obj;
            Date exprValue = (Date)getValue(ctx.expression());
            result = doCompare(obj, exprValue, ctx.op.getType());
            setValue(ctx, result);
        }
        else if (this.obj instanceof String && getValue(ctx.expression()) instanceof String)
        {

            String obj =(String)this.obj;
            String exprValue = (String)getValue(ctx.expression());
            if(ctx.op.getType() == RebbDTParser.EQUAL)
                result = obj.equals(exprValue);
            else
            {
                result = false;
                error = "Unsupported Operation";
            }
            setValue(ctx, result);
        }
        else
        {
            setValue(ctx, false);
            this.error = ObjectTypeNotSupported;
        }
        return null;
    }

    private <T> boolean doCompare(Comparable<T> obj, T v, int t)
    {
        boolean result = false;

        switch(t) {
            case RebbDTParser.EQUAL:
                result = obj.compareTo(v) == 0;
                break;
            case RebbDTParser.NEQUAL:
                result = obj.compareTo(v) != 0;
                break;
            case RebbDTParser.GT:
                result = obj.compareTo(v) > 0;
                break;
            case RebbDTParser.GTE:
                result = obj.compareTo(v) >= 0;
                break;
            case RebbDTParser.LT:
                result = obj.compareTo(v) < 0;
                break;
            case RebbDTParser.LTE:
                result = obj.compareTo(v) <= 0;
                break;
        }
        return result;
    }

    @Override
    public Void visitAgeCompare(RebbDTParser.AgeCompareContext ctx) {
        boolean result = false;
        visit(ctx.expression());
        Object exprValue = getValue(ctx.expression());
        if (this.obj instanceof Date && exprValue instanceof BigDecimal)
        {
            Date obj = (Date)this.obj;

            Calendar birth = Calendar.getInstance(this.timezone);
            birth.setTime(obj);

            Calendar now = Calendar.getInstance(this.timezone);
            now.setTime(new Date());

            long y = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
            if (now.get(Calendar.MONTH) < birth.get(Calendar.MONTH) ||
                    (now.get(Calendar.MONTH) == birth.get(Calendar.MONTH) && now.get(Calendar.DATE) < birth.get(Calendar.DATE))) {
                y--;
            }
            BigDecimal diff = BigDecimal.valueOf(y);

            switch(ctx.op.getType()) {
                case RebbDTParser.OLDER:
                    result = diff.compareTo((BigDecimal) exprValue)  >= 0;
                    break;
                case RebbDTParser.YOUNGER:
                    result = diff.compareTo((BigDecimal) exprValue) < 0;
                    break;
            }
            if(result){
                setValue(ctx, true);
            }
            else {
                setValue(ctx, false);
            }
        }
        else
        {
            this.valid = false;
            this.error = ObjectTypeNotSupported;
        }
        return null;
    }

    @Override
    public Void visitIsHex(RebbDTParser.IsHexContext ctx) {
        BuildInFunctions b = new BuildInFunctions(this.config);
        boolean result = true;
        switch (ctx.type.getType()) {
            case RebbDTParser.COLOR:
                result = b.checkHexColor();
                break;
            case RebbDTParser.NUMBER:
                result = b.checkHexNumber();
                break;
            default:
                result = false;
                break;
        }
        setValue(ctx, result);

        return null;
    }

    @Override
    public Void visitIs(RebbDTParser.IsContext ctx) {
        BuildInFunctions b = new BuildInFunctions(this.config);
        boolean result = false;
        switch(ctx.type.getType()) {
            case RebbDTParser.TRUE:
                result = b.checkTrue();
                break;
            case RebbDTParser.FALSE:
                result = b.checkFalse();
                break;
            case RebbDTParser.LEAPYEAR:
                result = b.checkLeapYear();
                break;
            case RebbDTParser.LEAPDAY:
                result = b.checkLeapDay();
                break;
            case RebbDTParser.DOMAIN:
                result = b.checkDomain();
                break;
            case RebbDTParser.EMAIL:
                result = b.checkEmail();
                break;
            case RebbDTParser.IPV4:
                result = b.checkIpv4();
                break;
            case RebbDTParser.IPV6:
                result = b.checkIpv6();
                break;
            case RebbDTParser.PRIVATEIP:
                result = b.checkPrivateIp();
                break;
            case RebbDTParser.URL:
                result = b.checkUrl();
                break;
            case RebbDTParser.MAC:
                result = b.checkMac();
                break;
            case RebbDTParser.IMEI:
                result = b.checkIMEI();
                break;
            case RebbDTParser.IMEISV:
                result = b.checkIMEISV();
                break;
            case RebbDTParser.ISBN:
                result = b.checkISBN();
                break;
            case RebbDTParser.PERCENTAGE:
                result = b.checkPercentage();
                break;
            case RebbDTParser.BASE64:
                result = b.checkBase64();
                break;
            case RebbDTParser.NUMBER:
                result = b.checkNumber();
                break;
            case RebbDTParser.INT:
                result = b.checkInt();
                break;
            case RebbDTParser.FLOAT:
                result = b.checkFloat();
                break;
            case RebbDTParser.PHONE:
                result = b.checkPhone();
                break;
            case RebbDTParser.MOBILE:
                result = b.checkMobile();
                break;
            case RebbDTParser.UUID:
                result = b.checkUUID();
                break;
            case RebbDTParser.GBCODE:
                result = b.checkGBCode();
                break;
            case RebbDTParser.ID:
                result = b.checkID();
                break;
            default:
                result = false;
                break;
        }
        setValue(ctx, result);

        return null;
    }

    @Override
    public Void visitMatch(RebbDTParser.MatchContext ctx) {
        if(this.obj instanceof String)
        {
            String regex = ctx.regex.getText().substring(1,ctx.regex.getText().length() - 2);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher((String)obj);
            setValue(ctx, matcher.find());
        }
        else
        {
            this.valid = false;
            this.error = ObjectTypeNotSupported;
        }

        return null;
    }

    @Override
    public Void visitStringPosition(RebbDTParser.StringPositionContext ctx) {
        RebbDTParser.ExpressionContext exprContext = ctx.expression();
        visit(exprContext);
        if(this.obj instanceof String && getValue(exprContext) instanceof String)
        {
            String obj = (String)this.obj;
            String exprValue = (String)getValue(exprContext);
            boolean result = false;
            if(ctx.op.getText().equals("starts"))
            {
                result = obj.startsWith(exprValue);
            }
            else if(ctx.op.getText().equals("ends"))
            {
                result = obj.endsWith(exprValue);
            }
            setValue(ctx, result);
        }
        else
        {
            this.setValue(ctx, false);
            this.error = ObjectTypeNotSupported;
        }
        return null;
    }

    @Override
    public Void visitIsCustom(RebbDTParser.IsCustomContext ctx) {
        String key = ctx.type.getText();
        if(customFunctions.containsKey(key))
        {
            Class validatorClass = customFunctions.get(key);

            Class[] types = {};
            Constructor constructor = null;
            try {
                constructor = validatorClass.getConstructor(types);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            Object[] parameters = {};
            try {
                assert constructor != null;
                IValidator validator = (IValidator)constructor.newInstance(parameters);
                if(validator.run(this.obj))
                    setValue(ctx, true);
                else
                    setValue(ctx, false);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (RebbDTException e) {
                setValue(ctx, false);
                error = e.getMessage();
                e.printStackTrace();
            }
        }
        else
            setValue(ctx, false);
        return super.visitIsCustom(ctx);
    }

    class BuildInFunctions
    {
        Calendar calendar = Calendar.getInstance();
        private Map<Integer, Object> config;
//        private String[] trueString = new String[] {"true","on", "1", "yes","ok"};
//        ArrayList<String> trueStringList = new ArrayList<>(Arrays.asList(trueString));

        public BuildInFunctions(Map<Integer, Object> config)
        {
            this.config = config;
        }
        public boolean checkTrue()
        {
            if(obj instanceof Boolean) {
                return (Boolean)obj == Boolean.TRUE;
            }
            else if(obj instanceof BigDecimal) {
                return ((BigDecimal) obj).compareTo(BigDecimal.valueOf(0)) != 0;
            }
            else if(obj instanceof String) {
                String s = (String)obj;
                if(this.config.containsKey(RebbDTConfig.TRUE_STRING) && this.config.get(RebbDTConfig.TRUE_STRING) instanceof String[])
                {
                    String[] trueStringList = (String[]) this.config.get(RebbDTConfig.TRUE_STRING);
                    return Arrays.asList(trueStringList).contains(s);
                }
                else
                    return false;
            }
            else
            {
                error = ObjectTypeNotSupported;
                return false;
            }
        }

        public boolean checkFalse()
        {
            if(obj instanceof Boolean) {
                return (Boolean)obj == Boolean.FALSE;
            }
            else if(obj instanceof BigDecimal) {
                return ((BigDecimal) obj).compareTo(BigDecimal.valueOf(0)) == 0;
            }
            else if(obj instanceof String) {
                String s = (String) obj;
                if(this.config.containsKey(RebbDTConfig.TRUE_STRING) && this.config.get(RebbDTConfig.TRUE_STRING) instanceof String[])
                {
                    String[] trueStringList = (String[]) this.config.get(RebbDTConfig.TRUE_STRING);
                    return !Arrays.asList(trueStringList).contains(s);
                } else
                    return false;
            }
            else
            {
                error = ObjectTypeNotBoolean;
                return false;
            }
        }

        public boolean checkLeapYear() {
            if(obj instanceof Date) {
                calendar.setTime((Date)obj);
                return calendar.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
            }
            else
            {
                error = ObjectTypeNotDate;
                return false;
            }
        }

        public boolean checkLeapDay() {
            if(obj instanceof Date) {
                calendar.setTime((Date)obj);
                return calendar.getActualMaximum(Calendar.DAY_OF_YEAR) > 365
                        && calendar.get(Calendar.MONTH) == Calendar.FEBRUARY
                        && calendar.get(Calendar.DAY_OF_MONTH) == 29;
            }
            else
            {
                error = ObjectTypeNotDate;
                return false;
            }
        }

        public boolean checkDomain()
        {
            String regex = "^(?:(?:(?<thld>[\\w\\-]*)(?:\\.))?(?<sld>[\\w\\-]*))\\.(?<tld>\\w*)(?:\\:(?<port>\\d*))?$";
            return checkRegex(regex);
        }

        public boolean checkEmail()
        {
            String regex = "^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$";
            return checkRegex(regex);
        }

        public boolean checkIpv4()
        {
            String regex = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
            return checkRegex(regex);
        }

        public boolean checkIpv6()
        {
            String regex = "^(\\p{XDigit}{1,4}(?::\\p{XDigit}{1,4}){7}|::|:(?::\\p{XDigit}{1,4}){1,6}|\\p{XDigit}{1,4}:(?::\\p{XDigit}{1,4}){1,5}|(?:\\p{XDigit}{1,4}:){2}(?::\\p{XDigit}{1,4}){1,4}|(?:\\p{XDigit}{1,4}:){3}(?::\\p{XDigit}{1,4}){1,3}|(?:\\p{XDigit}{1,4}:){4}(?::\\p{XDigit}{1,4}){1,2}|(?:\\p{XDigit}{1,4}:){5}:\\p{XDigit}{1,4}|(?:\\p{XDigit}{1,4}:){1,6}:)$";
            return checkRegex(regex);
        }

        public boolean checkPrivateIp()
        {
            if(obj instanceof String)
            {
                String object = (String)obj;
                String regex_ipv4 = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
                String regex_ipv6 = "^(\\p{XDigit}{1,4}(?::\\p{XDigit}{1,4}){7}|::|:(?::\\p{XDigit}{1,4}){1,6}|\\p{XDigit}{1,4}:(?::\\p{XDigit}{1,4}){1,5}|(?:\\p{XDigit}{1,4}:){2}(?::\\p{XDigit}{1,4}){1,4}|(?:\\p{XDigit}{1,4}:){3}(?::\\p{XDigit}{1,4}){1,3}|(?:\\p{XDigit}{1,4}:){4}(?::\\p{XDigit}{1,4}){1,2}|(?:\\p{XDigit}{1,4}:){5}:\\p{XDigit}{1,4}|(?:\\p{XDigit}{1,4}:){1,6}:)$";

                Pattern pattern_ipv4 = Pattern.compile(regex_ipv4);
                Pattern pattern_ipv6 = Pattern.compile(regex_ipv6);
                Matcher matcher_ipv4 = pattern_ipv4.matcher(object);
                Matcher matcher_ipv6 = pattern_ipv6.matcher(object);
                if (matcher_ipv4.find()) {
                    String regex_ipv4_private = "^(10(\\.(([0-9]?[0-9])|(1[0-9]?[0-9])|(2[0-4]?[0-9])|(25[0-5]))){3})|(172\\.((1[6-9])|(2[0-9])(3[0-1]))(\\.(([0-9]?[0-9])|(1[0-9]?[0-9])|(2[0-4]?[0-9])|(25[0-5]))){2})|(192\\.168(\\.(([0-9]?[0-9])|(1[0-9]?[0-9])|(2[0-4]?[0-9])|(25[0-5]))){2})|(127(\\.(([0-9]?[0-9])|(1[0-9]?[0-9])|(2[0-4]?[0-9])|(25[0-5]))){3})$";
                    Pattern pattern_ipv4_private = Pattern.compile(regex_ipv4_private);
                    Matcher matcher_ipv4_private = pattern_ipv4_private.matcher(object);
                    return matcher_ipv4_private.find();
                }
                else if(matcher_ipv6.find()){
                    return object.startsWith("FEC0:");
                }
                else
                {
                    return false;
                }
            }
            else
            {
                error = ObjectTypeNotString;
                return false;
            }
        }

        public boolean checkUrl()
        {
            String regex = "^((https?:)(\\/\\/\\/?)([\\w]*(?::[\\w]*)?@)?([\\d\\w\\.-]+)(?::(\\d+))?)?([\\/\\\\\\w\\.()-]*)?(?:([?][^#]*)?(#.*)?)*$";
            return checkRegex(regex);
        }

        public boolean checkIMEI()
        {
            String regex = "^(\\d{15})$|^(\\d{2}\\-\\d{6}\\-\\d{6}\\-\\d)$";
            boolean result = checkRegex(regex);
            if(result)
            {
                String imei = ((String)obj).replace("-","");

                int check = Integer.parseInt(imei.substring(14));
                imei = imei.substring(0, 14);

                char[] imeiChar = imei.toCharArray();
                int checksum = 0;
                for (int i = 0; i < imeiChar.length; i++) {
                    int weight = 1;
                    if(i % 2 == 1)
                        weight = 2;

                    int char_int = Integer.parseInt(String.valueOf(imeiChar[i])) * weight;
                    if(char_int >= 10)
                        char_int = char_int - 9;

                    checksum += char_int;
                }
                checksum %= 10;
                checksum = checksum == 0 ? 0 : 10 - checksum;

                return checksum == check;
            }
            return false;
        }

        public boolean checkIMEISV() {
            String regex = "^(\\d{16})$|^(\\d{2}\\-\\d{6}\\-\\d{6}\\-\\d{2})$";
            return checkRegex(regex);
        }

        public boolean checkISBN()
        {
            String regex = "^(?:ISBN(?:-1[03])?:?●)?(?=[-0-9●]{17}$|[-0-9X●]{13}$|[0-9X]{10}$)(?:97[89][-●]?)?[0-9]{1,5}[-●]?(?:[0-9]+[-●]?){2}[0-9X]$";
            boolean result =checkRegex(regex);
            if(result)
            {
                String isbn = ((String)obj).replace("-","");

                char[] isbnChar = isbn.toCharArray();
                int checksum = 0;
                for (int i = 0; i < isbnChar.length; i++) {
                    int weight = 1;
                    if(i % 2 == 1)
                        weight = 3;
                    int char_int = Integer.parseInt(String.valueOf(isbnChar[i]));
                    int a = char_int * weight;
                    checksum += a;
                }

                return checksum % 10 == 0;
            }
            return false;
        }

        public boolean checkUUID() {
            String regex = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
            return checkRegex(regex);
        }

        public boolean checkMac()
        {
            String regex = "^((?:[a-fA-F0-9]{2}[:-]){5}[a-fA-F0-9]{2})$";
            return checkRegex(regex);
        }

        public boolean checkPercentage() {
            String regex =  "^-?[1][0][0](\\.[0]{0,2})?%$|^-?[1-9]?[0-9](\\.[0-9]{0,2})?%$";
            return checkRegex(regex);
        }
        public boolean checkBase64() {
            String regex = "^(?:([a-z0-9A-Z+\\/]){4})*([a-z0-9A-Z+\\/])(?:([a-z0-9A-Z+\\/])==|([a-z0-9A-Z+\\/]){2}=|([a-z0-9A-Z+\\/]){3})$";
            return checkRegex(regex);
        }

        public boolean checkNumber() {
            String regex = "^(?<![\\w.])[+-]?(?:\\d+\\.\\d+|\\d+\\.|\\.\\d+|\\d+)(?:[eE][+-]?\\d+)?(?![\\w.])$";
            return checkRegex(regex);
        }

        public boolean checkInt() {
            String regex = "^[-+]?\\d+$";
            return checkRegex(regex);
        }

        public boolean checkFloat() {
            String regex = "^(?<![\\w.])[+-]?(?:\\d+\\.\\d+|\\d+\\.|\\.\\d+)(?![\\w.])$";
            return checkRegex(regex);
        }


        public boolean checkHexColor() {
            String regex = "^#(([\\da-fA-F]{3}){1,2}|([\\da-fA-F]{4}){1,2})$";
            return checkRegex(regex);
        }

        public boolean checkHexNumber() {
            String regex = "^(?:0[xX])?[\\da-fA-F]+$";
            return checkRegex(regex);
        }

        public boolean checkPhone() {
            String regex = "^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$";
            return checkRegex(regex);
        }

        public boolean checkMobile() {
            String regex = "^1[3-9]\\d{9}$";
            return checkRegex(regex);
        }

        public boolean checkGBCode() {
            String regex = "^\\d{6}$";
            boolean regexResult = checkRegex(regex);
            if(regexResult)
            {
                Integer[] gbcodes = {110000,110101,110102,110105,110106,110107,110108,110109,110111,110112,110113,110114,110115,110116,110117,110118,110119,120000,120101,120102,120103,120104,120105,120106,120110,120111,120112,120113,120114,120115,120116,120117,120118,120119,130000,130100,130102,130104,130105,130107,130108,130109,130110,130111,130121,130123,130125,130126,130127,130128,130129,130130,130131,130132,130133,130181,130183,130184,130200,130202,130203,130204,130205,130207,130208,130209,130224,130225,130227,130229,130281,130283,130284,130300,130302,130303,130304,130306,130321,130322,130324,130400,130402,130403,130404,130406,130407,130408,130423,130424,130425,130426,130427,130430,130431,130432,130433,130434,130435,130481,130500,130502,130503,130505,130506,130522,130523,130524,130525,130528,130529,130530,130531,130532,130533,130534,130535,130581,130582,130600,130602,130606,130607,130608,130609,130623,130624,130626,130627,130628,130629,130630,130631,130632,130633,130634,130635,130636,130637,130638,130681,130682,130683,130684,130700,130702,130703,130705,130706,130708,130709,130722,130723,130724,130725,130726,130727,130728,130730,130731,130732,130800,130802,130803,130804,130821,130822,130824,130825,130826,130827,130828,130881,130900,130902,130903,130921,130922,130923,130924,130925,130926,130927,130928,130929,130930,130981,130982,130983,130984,131000,131002,131003,131022,131023,131024,131025,131026,131028,131081,131082,131100,131102,131103,131121,131122,131123,131124,131125,131126,131127,131128,131182,140000,140100,140105,140106,140107,140108,140109,140110,140121,140122,140123,140181,140200,140212,140213,140214,140215,140221,140222,140223,140224,140225,140226,140300,140302,140303,140311,140321,140322,140400,140403,140404,140405,140406,140423,140425,140426,140427,140428,140429,140430,140431,140500,140502,140521,140522,140524,140525,140581,140600,140602,140603,140621,140622,140623,140681,140700,140702,140703,140721,140722,140723,140724,140725,140727,140728,140729,140781,140800,140802,140821,140822,140823,140824,140825,140826,140827,140828,140829,140830,140881,140882,140900,140902,140921,140922,140923,140924,140925,140926,140927,140928,140929,140930,140931,140932,140981,141000,141002,141021,141022,141023,141024,141025,141026,141027,141028,141029,141030,141031,141032,141033,141034,141081,141082,141100,141102,141121,141122,141123,141124,141125,141126,141127,141128,141129,141130,141181,141182,150000,150100,150102,150103,150104,150105,150121,150122,150123,150124,150125,150200,150202,150203,150204,150205,150206,150207,150221,150222,150223,150300,150302,150303,150304,150400,150402,150403,150404,150421,150422,150423,150424,150425,150426,150428,150429,150430,150500,150502,150521,150522,150523,150524,150525,150526,150581,150600,150602,150603,150621,150622,150623,150624,150625,150626,150627,150700,150702,150703,150721,150722,150723,150724,150725,150726,150727,150781,150782,150783,150784,150785,150800,150802,150821,150822,150823,150824,150825,150826,150900,150902,150921,150922,150923,150924,150925,150926,150927,150928,150929,150981,152200,152201,152202,152221,152222,152223,152224,152500,152501,152502,152522,152523,152524,152525,152526,152527,152528,152529,152530,152531,152900,152921,152922,152923,210000,210100,210102,210103,210104,210105,210106,210111,210112,210113,210114,210115,210123,210124,210181,210200,210202,210203,210204,210211,210212,210213,210214,210224,210281,210283,210300,210302,210303,210304,210311,210321,210323,210381,210400,210402,210403,210404,210411,210421,210422,210423,210500,210502,210503,210504,210505,210521,210522,210600,210602,210603,210604,210624,210681,210682,210700,210702,210703,210711,210726,210727,210781,210782,210800,210802,210803,210804,210811,210881,210882,210900,210902,210903,210904,210905,210911,210921,210922,211000,211002,211003,211004,211005,211011,211021,211081,211100,211102,211103,211104,211122,211200,211202,211204,211221,211223,211224,211281,211282,211300,211302,211303,211321,211322,211324,211381,211382,211400,211402,211403,211404,211421,211422,211481,220000,220100,220102,220103,220104,220105,220106,220112,220113,220122,220182,220183,220184,220200,220202,220203,220204,220211,220221,220281,220282,220283,220284,220300,220302,220303,220322,220323,220382,220400,220402,220403,220421,220422,220500,220502,220503,220521,220523,220524,220581,220582,220600,220602,220605,220621,220622,220623,220681,220700,220702,220721,220722,220723,220781,220800,220802,220821,220822,220881,220882,222400,222401,222402,222403,222404,222405,222406,222424,222426,230000,230100,230102,230103,230104,230108,230109,230110,230111,230112,230113,230123,230124,230125,230126,230127,230128,230129,230183,230184,230200,230202,230203,230204,230205,230206,230207,230208,230221,230223,230224,230225,230227,230229,230230,230231,230281,230300,230302,230303,230304,230305,230306,230307,230321,230381,230382,230400,230402,230403,230404,230405,230406,230407,230421,230422,230500,230502,230503,230505,230506,230521,230522,230523,230524,230600,230602,230603,230604,230605,230606,230621,230622,230623,230624,230700,230717,230718,230719,230722,230723,230724,230725,230726,230751,230781,230800,230803,230804,230805,230811,230822,230826,230828,230881,230882,230883,230900,230902,230903,230904,230921,231000,231002,231003,231004,231005,231025,231081,231083,231084,231085,231086,231100,231102,231123,231124,231181,231182,231183,231200,231202,231221,231222,231223,231224,231225,231226,231281,231282,231283,232700,232701,232721,232722,310000,310101,310104,310105,310106,310107,310109,310110,310112,310113,310114,310115,310116,310117,310118,310120,310151,320000,320100,320102,320104,320105,320106,320111,320113,320114,320115,320116,320117,320118,320200,320205,320206,320211,320213,320214,320281,320282,320300,320302,320303,320305,320311,320312,320321,320322,320324,320381,320382,320400,320402,320404,320411,320412,320413,320481,320500,320505,320506,320507,320508,320509,320581,320582,320583,320585,320600,320602,320611,320612,320623,320681,320682,320684,320685,320700,320703,320706,320707,320722,320723,320724,320800,320803,320804,320812,320813,320826,320830,320831,320900,320902,320903,320904,320921,320922,320923,320924,320925,320981,321000,321002,321003,321012,321023,321081,321084,321100,321102,321111,321112,321181,321182,321183,321200,321202,321203,321204,321281,321282,321283,321300,321302,321311,321322,321323,321324,330000,330100,330102,330103,330104,330105,330106,330108,330109,330110,330111,330112,330122,330127,330182,330200,330203,330205,330206,330211,330212,330213,330225,330226,330281,330282,330300,330302,330303,330304,330305,330324,330326,330327,330328,330329,330381,330382,330383,330400,330402,330411,330421,330424,330481,330482,330483,330500,330502,330503,330521,330522,330523,330600,330602,330603,330604,330624,330681,330683,330700,330702,330703,330723,330726,330727,330781,330782,330783,330784,330800,330802,330803,330822,330824,330825,330881,330900,330902,330903,330921,330922,331000,331002,331003,331004,331022,331023,331024,331081,331082,331083,331100,331102,331121,331122,331123,331124,331125,331126,331127,331181,340000,340100,340102,340103,340104,340111,340121,340122,340123,340124,340181,340200,340202,340207,340209,340210,340211,340223,340281,340300,340302,340303,340304,340311,340321,340322,340323,340400,340402,340403,340404,340405,340406,340421,340422,340500,340503,340504,340506,340521,340522,340523,340600,340602,340603,340604,340621,340700,340705,340706,340711,340722,340800,340802,340803,340811,340822,340825,340826,340827,340828,340881,340882,341000,341002,341003,341004,341021,341022,341023,341024,341100,341102,341103,341122,341124,341125,341126,341181,341182,341200,341202,341203,341204,341221,341222,341225,341226,341282,341300,341302,341321,341322,341323,341324,341500,341502,341503,341504,341522,341523,341524,341525,341600,341602,341621,341622,341623,341700,341702,341721,341722,341723,341800,341802,341821,341823,341824,341825,341881,341882,350000,350100,350102,350103,350104,350105,350111,350112,350121,350122,350123,350124,350125,350128,350181,350200,350203,350205,350206,350211,350212,350213,350300,350302,350303,350304,350305,350322,350400,350402,350403,350421,350423,350424,350425,350426,350427,350428,350429,350430,350481,350500,350502,350503,350504,350505,350521,350524,350525,350526,350527,350581,350582,350583,350600,350602,350603,350622,350623,350624,350625,350626,350627,350628,350629,350681,350700,350702,350703,350721,350722,350723,350724,350725,350781,350782,350783,350800,350802,350803,350821,350823,350824,350825,350881,350900,350902,350921,350922,350923,350924,350925,350926,350981,350982,360000,360100,360102,360103,360104,360111,360112,360113,360121,360123,360124,360200,360202,360203,360222,360281,360300,360302,360313,360321,360322,360323,360400,360402,360403,360404,360423,360424,360425,360426,360428,360429,360430,360481,360482,360483,360500,360502,360521,360600,360602,360603,360681,360700,360702,360703,360704,360722,360723,360724,360725,360726,360728,360729,360730,360731,360732,360733,360734,360735,360781,360783,360800,360802,360803,360821,360822,360823,360824,360825,360826,360827,360828,360829,360830,360881,360900,360902,360921,360922,360923,360924,360925,360926,360981,360982,360983,361000,361002,361003,361021,361022,361023,361024,361025,361026,361027,361028,361030,361100,361102,361103,361104,361123,361124,361125,361126,361127,361128,361129,361130,361181,370000,370100,370102,370103,370104,370105,370112,370113,370114,370115,370116,370117,370124,370126,370200,370202,370203,370211,370212,370213,370214,370215,370281,370283,370285,370300,370302,370303,370304,370305,370306,370321,370322,370323,370400,370402,370403,370404,370405,370406,370481,370500,370502,370503,370505,370522,370523,370600,370602,370611,370612,370613,370614,370681,370682,370683,370685,370686,370687,370700,370702,370703,370704,370705,370724,370725,370781,370782,370783,370784,370785,370786,370800,370811,370812,370826,370827,370828,370829,370830,370831,370832,370881,370883,370900,370902,370911,370921,370923,370982,370983,371000,371002,371003,371082,371083,371100,371102,371103,371121,371122,371300,371302,371311,371312,371321,371322,371323,371324,371325,371326,371327,371328,371329,371400,371402,371403,371422,371423,371424,371425,371426,371427,371428,371481,371482,371500,371502,371503,371521,371522,371524,371525,371526,371581,371600,371602,371603,371621,371622,371623,371625,371681,371700,371702,371703,371721,371722,371723,371724,371725,371726,371728,410000,410100,410102,410103,410104,410105,410106,410108,410122,410181,410182,410183,410184,410185,410200,410202,410203,410204,410205,410212,410221,410222,410223,410225,410300,410302,410303,410304,410305,410306,410311,410322,410323,410324,410325,410326,410327,410328,410329,410381,410400,410402,410403,410404,410411,410421,410422,410423,410425,410481,410482,410500,410502,410503,410505,410506,410522,410523,410526,410527,410581,410600,410602,410603,410611,410621,410622,410700,410702,410703,410704,410711,410721,410724,410725,410726,410727,410781,410782,410783,410800,410802,410803,410804,410811,410821,410822,410823,410825,410882,410883,410900,410902,410922,410923,410926,410927,410928,411000,411002,411003,411024,411025,411081,411082,411100,411102,411103,411104,411121,411122,411200,411202,411203,411221,411224,411281,411282,411300,411302,411303,411321,411322,411323,411324,411325,411326,411327,411328,411329,411330,411381,411400,411402,411403,411421,411422,411423,411424,411425,411426,411481,411500,411502,411503,411521,411522,411523,411524,411525,411526,411527,411528,411600,411602,411603,411621,411622,411623,411624,411625,411627,411628,411681,411700,411702,411721,411722,411723,411724,411725,411726,411727,411728,411729,419001,420000,420100,420102,420103,420104,420105,420106,420107,420111,420112,420113,420114,420115,420116,420117,420200,420202,420203,420204,420205,420222,420281,420300,420302,420303,420304,420322,420323,420324,420325,420381,420500,420502,420503,420504,420505,420506,420525,420526,420527,420528,420529,420581,420582,420583,420600,420602,420606,420607,420624,420625,420626,420682,420683,420684,420700,420702,420703,420704,420800,420802,420804,420822,420881,420882,420900,420902,420921,420922,420923,420981,420982,420984,421000,421002,421003,421022,421023,421024,421081,421083,421087,421100,421102,421121,421122,421123,421124,421125,421126,421127,421181,421182,421200,421202,421221,421222,421223,421224,421281,421300,421303,421321,421381,422800,422801,422802,422822,422823,422825,422826,422827,422828,429004,429005,429006,429021,430000,430100,430102,430103,430104,430105,430111,430112,430121,430181,430182,430200,430202,430203,430204,430211,430212,430223,430224,430225,430281,430300,430302,430304,430321,430381,430382,430400,430405,430406,430407,430408,430412,430421,430422,430423,430424,430426,430481,430482,430500,430502,430503,430511,430522,430523,430524,430525,430527,430528,430529,430581,430582,430600,430602,430603,430611,430621,430623,430624,430626,430681,430682,430700,430702,430703,430721,430722,430723,430724,430725,430726,430781,430800,430802,430811,430821,430822,430900,430902,430903,430921,430922,430923,430981,431000,431002,431003,431021,431022,431023,431024,431025,431026,431027,431028,431081,431100,431102,431103,431121,431122,431123,431124,431125,431126,431127,431128,431129,431200,431202,431221,431222,431223,431224,431225,431226,431227,431228,431229,431230,431281,431300,431302,431321,431322,431381,431382,433100,433101,433122,433123,433124,433125,433126,433127,433130,440000,440100,440103,440104,440105,440106,440111,440112,440113,440114,440115,440117,440118,440200,440203,440204,440205,440222,440224,440229,440232,440233,440281,440282,440300,440303,440304,440305,440306,440307,440308,440309,440310,440311,440400,440402,440403,440404,440500,440507,440511,440512,440513,440514,440515,440523,440600,440604,440605,440606,440607,440608,440700,440703,440704,440705,440781,440783,440784,440785,440800,440802,440803,440804,440811,440823,440825,440881,440882,440883,440900,440902,440904,440981,440982,440983,441200,441202,441203,441204,441223,441224,441225,441226,441284,441300,441302,441303,441322,441323,441324,441400,441402,441403,441422,441423,441424,441426,441427,441481,441500,441502,441521,441523,441581,441600,441602,441621,441622,441623,441624,441625,441700,441702,441704,441721,441781,441800,441802,441803,441821,441823,441825,441826,441881,441882,441900,442000,445100,445102,445103,445122,445200,445202,445203,445222,445224,445281,445300,445302,445303,445321,445322,445381,450000,450100,450102,450103,450105,450107,450108,450109,450110,450123,450124,450125,450126,450127,450200,450202,450203,450204,450205,450206,450222,450223,450224,450225,450226,450300,450302,450303,450304,450305,450311,450312,450321,450323,450324,450325,450326,450327,450328,450329,450330,450381,450332,450400,450403,450405,450406,450421,450422,450423,450481,450500,450502,450503,450512,450521,450600,450602,450603,450621,450681,450700,450702,450703,450721,450722,450800,450802,450803,450804,450821,450881,450900,450902,450903,450921,450922,450923,450924,450981,451000,451002,451003,451022,451024,451026,451027,451028,451029,451030,451031,451081,451082,451100,451102,451103,451121,451122,451123,451200,451202,451203,451221,451222,451223,451224,451225,451226,451227,451228,451229,451300,451302,451321,451322,451323,451324,451381,451400,451402,451421,451422,451423,451424,451425,451481,460000,460100,460105,460106,460107,460108,460200,460202,460203,460204,460205,460300,460400,469001,469002,469005,469006,469007,469021,469022,469023,469024,469025,469026,469027,469028,469029,469030,500000,500101,500102,500103,500104,500105,500106,500107,500108,500109,500110,500111,500112,500113,500114,500115,500116,500117,500118,500119,500120,500151,500152,500153,500154,500155,500156,500229,500230,500231,500233,500235,500236,500237,500238,500240,500241,500242,500243,510000,510100,510104,510105,510106,510107,510108,510112,510113,510114,510115,510116,510117,510118,510121,510129,510131,510181,510182,510183,510184,510185,510300,510302,510303,510304,510311,510321,510322,510400,510402,510403,510411,510421,510422,510500,510502,510503,510504,510521,510522,510524,510525,510600,510603,510604,510623,510681,510682,510683,510700,510703,510704,510705,510722,510723,510725,510726,510727,510781,510800,510802,510811,510812,510821,510822,510823,510824,510900,510903,510904,510921,510923,510981,511000,511002,511011,511024,511025,511083,511100,511102,511111,511112,511113,511123,511124,511126,511129,511132,511133,511181,511300,511302,511303,511304,511321,511322,511323,511324,511325,511381,511400,511402,511403,511421,511423,511424,511425,511500,511502,511503,511504,511523,511524,511525,511526,511527,511528,511529,511600,511602,511603,511621,511622,511623,511681,511700,511702,511703,511722,511723,511724,511725,511781,511800,511802,511803,511822,511823,511824,511825,511826,511827,511900,511902,511903,511921,511922,511923,512000,512002,512021,512022,513200,513201,513221,513222,513223,513224,513225,513226,513227,513228,513230,513231,513232,513233,513300,513301,513322,513323,513324,513325,513326,513327,513328,513329,513330,513331,513332,513333,513334,513335,513336,513337,513338,513400,513401,513422,513423,513424,513425,513426,513427,513428,513429,513430,513431,513432,513433,513434,513435,513436,513437,520000,520100,520102,520103,520111,520112,520113,520115,520121,520122,520123,520181,520200,520201,520203,520221,520281,520300,520302,520303,520304,520322,520323,520324,520325,520326,520327,520328,520329,520330,520381,520382,520400,520402,520403,520422,520423,520424,520425,520500,520502,520521,520522,520523,520524,520525,520526,520527,520600,520602,520603,520621,520622,520623,520624,520625,520626,520627,520628,522300,522301,522302,522323,522324,522325,522326,522327,522328,522600,522601,522622,522623,522624,522625,522626,522627,522628,522629,522630,522631,522632,522633,522634,522635,522636,522700,522701,522702,522722,522723,522725,522726,522727,522728,522729,522730,522731,522732,530000,530100,530102,530103,530111,530112,530113,530114,530115,530124,530125,530126,530127,530128,530129,530181,530300,530302,530303,530304,530322,530323,530324,530325,530326,530381,530400,530402,530403,530423,530424,530425,530426,530427,530428,530481,530500,530502,530521,530523,530524,530581,530600,530602,530621,530622,530623,530624,530625,530626,530627,530628,530629,530681,530700,530702,530721,530722,530723,530724,530800,530802,530821,530822,530823,530824,530825,530826,530827,530828,530829,530900,530902,530921,530922,530923,530924,530925,530926,530927,532300,532301,532322,532323,532324,532325,532326,532327,532328,532329,532331,532500,532501,532502,532503,532504,532523,532524,532525,532527,532528,532529,532530,532531,532532,532600,532601,532622,532623,532624,532625,532626,532627,532628,532800,532801,532822,532823,532900,532901,532922,532923,532924,532925,532926,532927,532928,532929,532930,532931,532932,533100,533102,533103,533122,533123,533124,533300,533301,533323,533324,533325,533400,533401,533422,533423,540000,540100,540102,540103,540104,540121,540122,540123,540124,540127,540200,540202,540221,540222,540223,540224,540225,540226,540227,540228,540229,540230,540231,540232,540233,540234,540235,540236,540237,540300,540302,540321,540322,540323,540324,540325,540326,540327,540328,540329,540330,540400,540402,540421,540422,540423,540424,540425,540426,540500,540502,540521,540522,540523,540524,540525,540526,540527,540528,540529,540530,540531,540600,540602,540621,540622,540623,540624,540625,540626,540627,540628,540629,540630,542500,542521,542522,542523,542524,542525,542526,542527,610000,610100,610102,610103,610104,610111,610112,610113,610114,610115,610116,610117,610118,610122,610124,610200,610202,610203,610204,610222,610300,610302,610303,610304,610322,610323,610324,610326,610327,610328,610329,610330,610331,610400,610402,610403,610404,610422,610423,610424,610425,610426,610428,610429,610430,610431,610481,610482,610500,610502,610503,610522,610523,610524,610525,610526,610527,610528,610581,610582,610600,610602,610603,610621,610622,610625,610626,610627,610628,610629,610630,610631,610632,610681,610700,610702,610703,610722,610723,610724,610725,610726,610727,610728,610729,610730,610800,610802,610803,610822,610824,610825,610826,610827,610828,610829,610830,610831,610881,610900,610902,610921,610922,610923,610924,610925,610926,610927,610928,610929,611000,611002,611021,611022,611023,611024,611025,611026,620000,620100,620102,620103,620104,620105,620111,620121,620122,620123,620200,620300,620302,620321,620400,620402,620403,620421,620422,620423,620500,620502,620503,620521,620522,620523,620524,620525,620600,620602,620621,620622,620623,620700,620702,620721,620722,620723,620724,620725,620800,620802,620821,620822,620823,620825,620826,620881,620900,620902,620921,620922,620923,620924,620981,620982,621000,621002,621021,621022,621023,621024,621025,621026,621027,621100,621102,621121,621122,621123,621124,621125,621126,621200,621202,621221,621222,621223,621224,621225,621226,621227,621228,622900,622901,622921,622922,622923,622924,622925,622926,622927,623000,623001,623021,623022,623023,623024,623025,623026,623027,630000,630100,630102,630103,630104,630105,630106,630121,630123,630200,630202,630203,630222,630223,630224,630225,632200,632221,632222,632223,632224,632300,632301,632322,632323,632324,632500,632521,632522,632523,632524,632525,632600,632621,632622,632623,632624,632625,632626,632700,632701,632722,632723,632724,632725,632726,632800,632801,632802,632803,632821,632822,632823,640000,640100,640104,640105,640106,640121,640122,640181,640200,640202,640205,640221,640300,640302,640303,640323,640324,640381,640400,640402,640422,640423,640424,640425,640500,640502,640521,640522,650000,650100,650102,650103,650104,650105,650106,650107,650109,650121,650200,650202,650203,650204,650205,650400,650402,650421,650422,650500,650502,650521,650522,652300,652301,652302,652323,652324,652325,652327,652328,652700,652701,652702,652722,652723,652800,652801,652822,652823,652824,652825,652826,652827,652828,652829,652900,652901,652902,652922,652924,652925,652926,652927,652928,652929,653000,653001,653022,653023,653024,653100,653101,653121,653122,653123,653124,653125,653126,653127,653128,653129,653130,653131,653200,653201,653221,653222,653223,653224,653225,653226,653227,654000,654002,654003,654004,654021,654022,654023,654024,654025,654026,654027,654028,654200,654201,654202,654221,654223,654224,654225,654226,654300,654301,654321,654322,654323,654324,654325,654326,659001,659002,659003,659004,659005,659006,659007,659008,659009,659010,710000,810000,820000};
                Integer object = Integer.valueOf((String)obj);
                return Arrays.asList(gbcodes).contains(object);
            }
            else
                return false;
        }

        public boolean checkID() {
            String regex = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)";
            boolean regexResult = checkRegex(regex);
            if(!regexResult)
                return false;

            String id = (String)obj;

            //check area code
            Integer[] areas = {11,12,13,14,15,21,22,23,31,32,33,34,35,36,37,41,42,43,44,45,46,50,51,52,53,54,61,62,63,64,65,71,81,82,91};
            Integer area = Integer.valueOf(id.substring(0,2));
            if(!Arrays.asList(areas).contains(area))
                return false;

            //check birthday
            String birthday = id.substring(6,14);
            try {
                DateFormat df = new SimpleDateFormat("yyyyMMdd");
                Date date = df.parse(birthday);
                if(!df.format(date).equals(birthday))
                    return false;
            } catch (ParseException e) {
                error = e.getMessage();
                return false;
            }

            //checksum
            char[] idChar = id.toCharArray();
            int checksum = 0;
            int[] weight = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
            for (int i = 0; i < 17; i++) {
                int char_int = Integer.parseInt(String.valueOf(idChar[i]));
                int a = char_int * weight[i];
                checksum += a;
            }
            String[] checksumCharList = {"1","0","X","9","8","7","6","5","4","3","2"};
            String checksumChar = checksumCharList[checksum%11];
            return checksumChar.equals(id.substring(id.length() - 1));
        }
        public boolean checkRegex(String regex)
        {
            if(obj instanceof String)
            {
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher((String)obj);
                return matcher.find();
            }
            else
            {
                error = ObjectTypeNotString;
                return false;
            }
        }

    }
}
