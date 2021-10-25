// Generated from RebbDT.g4 by ANTLR 4.9
package tech.rebb.dt;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RebbDTParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, RegularExpressionLiteral=24, 
		StringLiteral=25, NumbericLiteral=26, DateLiteral=27, TimeLiteral=28, 
		DIGITS=29, YEAR=30, MONTH=31, DAY=32, HOUR=33, MINUTE=34, SECOND=35, EQUAL=36, 
		NEQUAL=37, LT=38, LTE=39, GT=40, GTE=41, OLDER=42, YOUNGER=43, TRUE=44, 
		FALSE=45, LEAPYEAR=46, LEAPDAY=47, DOMAIN=48, EMAIL=49, IPV4=50, IPV6=51, 
		PRIVATEIP=52, URL=53, MAC=54, IMEI=55, IMEISV=56, ISBN=57, PERCENTAGE=58, 
		BASE64=59, NUMBER=60, INT=61, FLOAT=62, COLOR=63, PHONE=64, MOBILE=65, 
		UUID=66, GBCODE=67, ID=68, PASSPORT=69, CustomFunction=70, NEWLINE=71, 
		WS=72;
	public static final int
		RULE_unaryTests = 0, RULE_unaryTest = 1, RULE_positiveUnaryTest = 2, RULE_expression = 3, 
		RULE_arrayLiteral = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"unaryTests", "unaryTest", "positiveUnaryTest", "expression", "arrayLiteral"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'and'", "'or'", "'not'", "'('", "')'", "'-'", "'between'", "'in'", 
			"'contains'", "'empty'", "'max'", "'length'", "'is'", "'hex'", "'match'", 
			"'than'", "'starts'", "'ends'", "'with'", "']'", "'['", "'..'", "','", 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"'='", "'!='", "'<'", "'<='", "'>'", "'>='", "'older'", "'younger'", 
			"'true'", "'false'", "'leapyear'", "'leapday'", "'domain'", "'email'", 
			"'ipv4'", "'ipv6'", "'private_ip'", "'url'", "'MAC'", "'IMEI'", "'IMEISV'", 
			"'ISBN'", "'percentage'", "'base64'", "'number'", "'int'", "'float'", 
			"'color'", "'phone'", "'mobile'", "'UUID'", "'gbcode'", "'ID'", "'passport'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"RegularExpressionLiteral", "StringLiteral", "NumbericLiteral", "DateLiteral", 
			"TimeLiteral", "DIGITS", "YEAR", "MONTH", "DAY", "HOUR", "MINUTE", "SECOND", 
			"EQUAL", "NEQUAL", "LT", "LTE", "GT", "GTE", "OLDER", "YOUNGER", "TRUE", 
			"FALSE", "LEAPYEAR", "LEAPDAY", "DOMAIN", "EMAIL", "IPV4", "IPV6", "PRIVATEIP", 
			"URL", "MAC", "IMEI", "IMEISV", "ISBN", "PERCENTAGE", "BASE64", "NUMBER", 
			"INT", "FLOAT", "COLOR", "PHONE", "MOBILE", "UUID", "GBCODE", "ID", "PASSPORT", 
			"CustomFunction", "NEWLINE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "RebbDT.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RebbDTParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class UnaryTestsContext extends ParserRuleContext {
		public UnaryTestsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryTests; }
	 
		public UnaryTestsContext() { }
		public void copyFrom(UnaryTestsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DisjunctionContext extends UnaryTestsContext {
		public UnaryTestsContext unaryTests() {
			return getRuleContext(UnaryTestsContext.class,0);
		}
		public UnaryTestContext unaryTest() {
			return getRuleContext(UnaryTestContext.class,0);
		}
		public DisjunctionContext(UnaryTestsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterDisjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitDisjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitDisjunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConjunctionContext extends UnaryTestsContext {
		public UnaryTestsContext unaryTests() {
			return getRuleContext(UnaryTestsContext.class,0);
		}
		public UnaryTestContext unaryTest() {
			return getRuleContext(UnaryTestContext.class,0);
		}
		public ConjunctionContext(UnaryTestsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitConjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitConjunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleTestContext extends UnaryTestsContext {
		public UnaryTestContext unaryTest() {
			return getRuleContext(UnaryTestContext.class,0);
		}
		public SingleTestContext(UnaryTestsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterSingleTest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitSingleTest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitSingleTest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryTestsContext unaryTests() throws RecognitionException {
		return unaryTests(0);
	}

	private UnaryTestsContext unaryTests(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		UnaryTestsContext _localctx = new UnaryTestsContext(_ctx, _parentState);
		UnaryTestsContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_unaryTests, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SingleTestContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(11);
			unaryTest();
			}
			_ctx.stop = _input.LT(-1);
			setState(21);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(19);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						_localctx = new ConjunctionContext(new UnaryTestsContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_unaryTests);
						setState(13);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(14);
						match(T__0);
						setState(15);
						unaryTest();
						}
						break;
					case 2:
						{
						_localctx = new DisjunctionContext(new UnaryTestsContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_unaryTests);
						setState(16);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(17);
						match(T__1);
						setState(18);
						unaryTest();
						}
						break;
					}
					} 
				}
				setState(23);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryTestContext extends ParserRuleContext {
		public UnaryTestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryTest; }
	 
		public UnaryTestContext() { }
		public void copyFrom(UnaryTestContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IgnoreUnaryTestContext extends UnaryTestContext {
		public IgnoreUnaryTestContext(UnaryTestContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterIgnoreUnaryTest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitIgnoreUnaryTest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitIgnoreUnaryTest(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NormalUnaryTestContext extends UnaryTestContext {
		public PositiveUnaryTestContext positiveUnaryTest() {
			return getRuleContext(PositiveUnaryTestContext.class,0);
		}
		public NormalUnaryTestContext(UnaryTestContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterNormalUnaryTest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitNormalUnaryTest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitNormalUnaryTest(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegationUnaryTestContext extends UnaryTestContext {
		public PositiveUnaryTestContext positiveUnaryTest() {
			return getRuleContext(PositiveUnaryTestContext.class,0);
		}
		public NegationUnaryTestContext(UnaryTestContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterNegationUnaryTest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitNegationUnaryTest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitNegationUnaryTest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryTestContext unaryTest() throws RecognitionException {
		UnaryTestContext _localctx = new UnaryTestContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_unaryTest);
		try {
			setState(34);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new NormalUnaryTestContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				positiveUnaryTest();
				}
				break;
			case 2:
				_localctx = new NegationUnaryTestContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				match(T__2);
				setState(27);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(26);
					match(T__3);
					}
					break;
				}
				setState(29);
				positiveUnaryTest();
				setState(31);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(30);
					match(T__4);
					}
					break;
				}
				}
				break;
			case 3:
				_localctx = new IgnoreUnaryTestContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(33);
				match(T__5);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PositiveUnaryTestContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PositiveUnaryTestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_positiveUnaryTest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterPositiveUnaryTest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitPositiveUnaryTest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitPositiveUnaryTest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PositiveUnaryTestContext positiveUnaryTest() throws RecognitionException {
		PositiveUnaryTestContext _localctx = new PositiveUnaryTestContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_positiveUnaryTest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DateContext extends ExpressionContext {
		public TerminalNode DateLiteral() { return getToken(RebbDTParser.DateLiteral, 0); }
		public DateContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitDate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AgeCompareContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode OLDER() { return getToken(RebbDTParser.OLDER, 0); }
		public TerminalNode YOUNGER() { return getToken(RebbDTParser.YOUNGER, 0); }
		public AgeCompareContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterAgeCompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitAgeCompare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitAgeCompare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends ExpressionContext {
		public TerminalNode StringLiteral() { return getToken(RebbDTParser.StringLiteral, 0); }
		public StringContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitIn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitIn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsCustomContext extends ExpressionContext {
		public Token type;
		public TerminalNode CustomFunction() { return getToken(RebbDTParser.CustomFunction, 0); }
		public IsCustomContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterIsCustom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitIsCustom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitIsCustom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BetweenContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BetweenContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterBetween(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitBetween(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitBetween(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsContext extends ExpressionContext {
		public Token type;
		public TerminalNode TRUE() { return getToken(RebbDTParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(RebbDTParser.FALSE, 0); }
		public TerminalNode LEAPYEAR() { return getToken(RebbDTParser.LEAPYEAR, 0); }
		public TerminalNode LEAPDAY() { return getToken(RebbDTParser.LEAPDAY, 0); }
		public TerminalNode DOMAIN() { return getToken(RebbDTParser.DOMAIN, 0); }
		public TerminalNode EMAIL() { return getToken(RebbDTParser.EMAIL, 0); }
		public TerminalNode IPV4() { return getToken(RebbDTParser.IPV4, 0); }
		public TerminalNode IPV6() { return getToken(RebbDTParser.IPV6, 0); }
		public TerminalNode PRIVATEIP() { return getToken(RebbDTParser.PRIVATEIP, 0); }
		public TerminalNode URL() { return getToken(RebbDTParser.URL, 0); }
		public TerminalNode MAC() { return getToken(RebbDTParser.MAC, 0); }
		public TerminalNode IMEI() { return getToken(RebbDTParser.IMEI, 0); }
		public TerminalNode IMEISV() { return getToken(RebbDTParser.IMEISV, 0); }
		public TerminalNode ISBN() { return getToken(RebbDTParser.ISBN, 0); }
		public TerminalNode PERCENTAGE() { return getToken(RebbDTParser.PERCENTAGE, 0); }
		public TerminalNode BASE64() { return getToken(RebbDTParser.BASE64, 0); }
		public TerminalNode NUMBER() { return getToken(RebbDTParser.NUMBER, 0); }
		public TerminalNode INT() { return getToken(RebbDTParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(RebbDTParser.FLOAT, 0); }
		public TerminalNode PHONE() { return getToken(RebbDTParser.PHONE, 0); }
		public TerminalNode MOBILE() { return getToken(RebbDTParser.MOBILE, 0); }
		public TerminalNode UUID() { return getToken(RebbDTParser.UUID, 0); }
		public TerminalNode GBCODE() { return getToken(RebbDTParser.GBCODE, 0); }
		public TerminalNode ID() { return getToken(RebbDTParser.ID, 0); }
		public TerminalNode PASSPORT() { return getToken(RebbDTParser.PASSPORT, 0); }
		public IsContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterIs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitIs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitIs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsHexContext extends ExpressionContext {
		public Token type;
		public TerminalNode COLOR() { return getToken(RebbDTParser.COLOR, 0); }
		public TerminalNode NUMBER() { return getToken(RebbDTParser.NUMBER, 0); }
		public IsHexContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterIsHex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitIsHex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitIsHex(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MaxLengthContext extends ExpressionContext {
		public TerminalNode NumbericLiteral() { return getToken(RebbDTParser.NumbericLiteral, 0); }
		public MaxLengthContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterMaxLength(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitMaxLength(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitMaxLength(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringPositionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StringPositionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterStringPosition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitStringPosition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitStringPosition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MatchContext extends ExpressionContext {
		public Token regex;
		public TerminalNode RegularExpressionLiteral() { return getToken(RebbDTParser.RegularExpressionLiteral, 0); }
		public MatchContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitMatch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitMatch(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayContext extends ExpressionContext {
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public ArrayContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberContext extends ExpressionContext {
		public TerminalNode NumbericLiteral() { return getToken(RebbDTParser.NumbericLiteral, 0); }
		public NumberContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContainsContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ContainsContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterContains(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitContains(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitContains(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompareContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(RebbDTParser.EQUAL, 0); }
		public TerminalNode NEQUAL() { return getToken(RebbDTParser.NEQUAL, 0); }
		public TerminalNode LT() { return getToken(RebbDTParser.LT, 0); }
		public TerminalNode LTE() { return getToken(RebbDTParser.LTE, 0); }
		public TerminalNode GT() { return getToken(RebbDTParser.GT, 0); }
		public TerminalNode GTE() { return getToken(RebbDTParser.GTE, 0); }
		public CompareContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterCompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitCompare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitCompare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotEmptyContext extends ExpressionContext {
		public NotEmptyContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterNotEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitNotEmpty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitNotEmpty(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TimeContext extends ExpressionContext {
		public TerminalNode TimeLiteral() { return getToken(RebbDTParser.TimeLiteral, 0); }
		public TimeContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitTime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitTime(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntervalContext extends ExpressionContext {
		public Token start;
		public Token end;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IntervalContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterInterval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitInterval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitInterval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expression);
		int _la;
		try {
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new CompareContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				((CompareContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << NEQUAL) | (1L << LT) | (1L << LTE) | (1L << GT) | (1L << GTE))) != 0)) ) {
					((CompareContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(39);
				expression();
				}
				break;
			case 2:
				_localctx = new BetweenContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				match(T__6);
				setState(41);
				expression();
				setState(42);
				match(T__0);
				setState(43);
				expression();
				}
				break;
			case 3:
				_localctx = new InContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				match(T__7);
				setState(46);
				expression();
				}
				break;
			case 4:
				_localctx = new ContainsContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				match(T__8);
				setState(48);
				expression();
				}
				break;
			case 5:
				_localctx = new NotEmptyContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(49);
				match(T__2);
				setState(50);
				match(T__9);
				}
				break;
			case 6:
				_localctx = new MaxLengthContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(51);
				match(T__10);
				setState(52);
				match(T__11);
				setState(53);
				match(NumbericLiteral);
				}
				break;
			case 7:
				_localctx = new IsContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(54);
				match(T__12);
				setState(55);
				((IsContext)_localctx).type = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & ((1L << (TRUE - 44)) | (1L << (FALSE - 44)) | (1L << (LEAPYEAR - 44)) | (1L << (LEAPDAY - 44)) | (1L << (DOMAIN - 44)) | (1L << (EMAIL - 44)) | (1L << (IPV4 - 44)) | (1L << (IPV6 - 44)) | (1L << (PRIVATEIP - 44)) | (1L << (URL - 44)) | (1L << (MAC - 44)) | (1L << (IMEI - 44)) | (1L << (IMEISV - 44)) | (1L << (ISBN - 44)) | (1L << (PERCENTAGE - 44)) | (1L << (BASE64 - 44)) | (1L << (NUMBER - 44)) | (1L << (INT - 44)) | (1L << (FLOAT - 44)) | (1L << (PHONE - 44)) | (1L << (MOBILE - 44)) | (1L << (UUID - 44)) | (1L << (GBCODE - 44)) | (1L << (ID - 44)) | (1L << (PASSPORT - 44)))) != 0)) ) {
					((IsContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 8:
				_localctx = new IsHexContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(56);
				match(T__12);
				setState(57);
				match(T__13);
				setState(58);
				((IsHexContext)_localctx).type = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NUMBER || _la==COLOR) ) {
					((IsHexContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 9:
				_localctx = new IsCustomContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(59);
				match(T__12);
				setState(60);
				((IsCustomContext)_localctx).type = match(CustomFunction);
				}
				break;
			case 10:
				_localctx = new MatchContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(61);
				match(T__14);
				setState(62);
				((MatchContext)_localctx).regex = match(RegularExpressionLiteral);
				}
				break;
			case 11:
				_localctx = new AgeCompareContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(63);
				((AgeCompareContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==OLDER || _la==YOUNGER) ) {
					((AgeCompareContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(64);
				match(T__15);
				setState(65);
				expression();
				}
				break;
			case 12:
				_localctx = new StringPositionContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(66);
				((StringPositionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__16 || _la==T__17) ) {
					((StringPositionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(67);
				match(T__18);
				setState(68);
				expression();
				}
				break;
			case 13:
				_localctx = new IntervalContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(69);
				((IntervalContext)_localctx).start = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__19) | (1L << T__20))) != 0)) ) {
					((IntervalContext)_localctx).start = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(70);
				expression();
				setState(71);
				match(T__21);
				setState(72);
				expression();
				setState(73);
				((IntervalContext)_localctx).end = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__19) | (1L << T__20))) != 0)) ) {
					((IntervalContext)_localctx).end = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 14:
				_localctx = new ArrayContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(75);
				arrayLiteral();
				}
				break;
			case 15:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(76);
				match(StringLiteral);
				}
				break;
			case 16:
				_localctx = new NumberContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(77);
				match(NumbericLiteral);
				}
				break;
			case 17:
				_localctx = new DateContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(78);
				match(DateLiteral);
				}
				break;
			case 18:
				_localctx = new TimeContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(79);
				match(TimeLiteral);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayLiteralContext extends ParserRuleContext {
		public List<TerminalNode> NumbericLiteral() { return getTokens(RebbDTParser.NumbericLiteral); }
		public TerminalNode NumbericLiteral(int i) {
			return getToken(RebbDTParser.NumbericLiteral, i);
		}
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).enterArrayLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RebbDTListener ) ((RebbDTListener)listener).exitArrayLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RebbDTVisitor ) return ((RebbDTVisitor<? extends T>)visitor).visitArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arrayLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__20);
			setState(83);
			match(NumbericLiteral);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22) {
				{
				{
				setState(84);
				match(T__22);
				setState(85);
				match(NumbericLiteral);
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91);
			match(T__19);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return unaryTests_sempred((UnaryTestsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean unaryTests_sempred(UnaryTestsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3J`\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\26\n"+
		"\2\f\2\16\2\31\13\2\3\3\3\3\3\3\5\3\36\n\3\3\3\3\3\5\3\"\n\3\3\3\5\3%"+
		"\n\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5S\n\5\3\6\3\6\3\6\3\6\7\6"+
		"Y\n\6\f\6\16\6\\\13\6\3\6\3\6\3\6\2\3\2\7\2\4\6\b\n\2\t\3\2&+\4\2.@BG"+
		"\4\2>>AA\3\2,-\3\2\23\24\4\2\6\6\26\27\4\2\7\7\26\27\2r\2\f\3\2\2\2\4"+
		"$\3\2\2\2\6&\3\2\2\2\bR\3\2\2\2\nT\3\2\2\2\f\r\b\2\1\2\r\16\5\4\3\2\16"+
		"\27\3\2\2\2\17\20\f\5\2\2\20\21\7\3\2\2\21\26\5\4\3\2\22\23\f\4\2\2\23"+
		"\24\7\4\2\2\24\26\5\4\3\2\25\17\3\2\2\2\25\22\3\2\2\2\26\31\3\2\2\2\27"+
		"\25\3\2\2\2\27\30\3\2\2\2\30\3\3\2\2\2\31\27\3\2\2\2\32%\5\6\4\2\33\35"+
		"\7\5\2\2\34\36\7\6\2\2\35\34\3\2\2\2\35\36\3\2\2\2\36\37\3\2\2\2\37!\5"+
		"\6\4\2 \"\7\7\2\2! \3\2\2\2!\"\3\2\2\2\"%\3\2\2\2#%\7\b\2\2$\32\3\2\2"+
		"\2$\33\3\2\2\2$#\3\2\2\2%\5\3\2\2\2&\'\5\b\5\2\'\7\3\2\2\2()\t\2\2\2)"+
		"S\5\b\5\2*+\7\t\2\2+,\5\b\5\2,-\7\3\2\2-.\5\b\5\2.S\3\2\2\2/\60\7\n\2"+
		"\2\60S\5\b\5\2\61\62\7\13\2\2\62S\5\b\5\2\63\64\7\5\2\2\64S\7\f\2\2\65"+
		"\66\7\r\2\2\66\67\7\16\2\2\67S\7\34\2\289\7\17\2\29S\t\3\2\2:;\7\17\2"+
		"\2;<\7\20\2\2<S\t\4\2\2=>\7\17\2\2>S\7H\2\2?@\7\21\2\2@S\7\32\2\2AB\t"+
		"\5\2\2BC\7\22\2\2CS\5\b\5\2DE\t\6\2\2EF\7\25\2\2FS\5\b\5\2GH\t\7\2\2H"+
		"I\5\b\5\2IJ\7\30\2\2JK\5\b\5\2KL\t\b\2\2LS\3\2\2\2MS\5\n\6\2NS\7\33\2"+
		"\2OS\7\34\2\2PS\7\35\2\2QS\7\36\2\2R(\3\2\2\2R*\3\2\2\2R/\3\2\2\2R\61"+
		"\3\2\2\2R\63\3\2\2\2R\65\3\2\2\2R8\3\2\2\2R:\3\2\2\2R=\3\2\2\2R?\3\2\2"+
		"\2RA\3\2\2\2RD\3\2\2\2RG\3\2\2\2RM\3\2\2\2RN\3\2\2\2RO\3\2\2\2RP\3\2\2"+
		"\2RQ\3\2\2\2S\t\3\2\2\2TU\7\27\2\2UZ\7\34\2\2VW\7\31\2\2WY\7\34\2\2XV"+
		"\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2]^\7\26\2"+
		"\2^\13\3\2\2\2\t\25\27\35!$RZ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}