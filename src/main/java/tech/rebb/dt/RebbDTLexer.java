// Generated from RebbDT.g4 by ANTLR 4.9
package tech.rebb.dt;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RebbDTLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "RegularExpressionLiteral", 
			"RegularExpressionBody", "RegularExpressionFlags", "RegularExpressionFlag", 
			"RegularExpressionFirstChar", "RegularExpressionChar", "RegularExpressionBackslashSequence", 
			"RegularExpressionClass", "RegularExpressionClassChar", "RegularExpressionNonTerminator", 
			"StringLiteral", "NumbericLiteral", "DateLiteral", "TimeLiteral", "StringCharacters", 
			"StringCharacter", "EscapeSequence", "DIGIT", "DIGITS", "YEAR", "MONTH", 
			"DAY", "HOUR", "MINUTE", "SECOND", "EQUAL", "NEQUAL", "LT", "LTE", "GT", 
			"GTE", "OLDER", "YOUNGER", "TRUE", "FALSE", "LEAPYEAR", "LEAPDAY", "DOMAIN", 
			"EMAIL", "IPV4", "IPV6", "PRIVATEIP", "URL", "MAC", "IMEI", "IMEISV", 
			"ISBN", "PERCENTAGE", "BASE64", "NUMBER", "INT", "FLOAT", "COLOR", "PHONE", 
			"MOBILE", "UUID", "GBCODE", "ID", "PASSPORT", "CustomFunction", "NEWLINE", 
			"WS"
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


	public RebbDTLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RebbDT.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2J\u0280\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\7\32\u0117\n\32\f\32\16\32\u011a\13\32\3\33\7\33\u011d\n\33\f\33\16\33"+
		"\u0120\13\33\3\34\3\34\3\35\3\35\3\35\5\35\u0127\n\35\3\36\3\36\3\36\5"+
		"\36\u012c\n\36\3\37\3\37\3\37\3 \3 \7 \u0133\n \f \16 \u0136\13 \3 \3"+
		" \3!\3!\5!\u013c\n!\3\"\3\"\3#\3#\5#\u0142\n#\3#\3#\3$\5$\u0147\n$\3$"+
		"\3$\3$\6$\u014c\n$\r$\16$\u014d\3$\5$\u0151\n$\3$\5$\u0154\n$\3%\3%\3"+
		"%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\6\'\u0163\n\'\r\'\16\'\u0164\3(\3(\5"+
		"(\u0169\n(\3)\3)\3)\3*\3*\3+\6+\u0171\n+\r+\16+\u0172\3,\3,\3,\3,\3,\3"+
		"-\5-\u017b\n-\3-\3-\3-\3-\3-\3-\3-\5-\u0184\n-\5-\u0186\n-\3.\5.\u0189"+
		"\n.\3.\3.\3.\3.\3.\5.\u0190\n.\5.\u0192\n.\3/\5/\u0195\n/\3/\3/\3/\3/"+
		"\3/\3/\3/\3/\3/\5/\u01a0\n/\5/\u01a2\n/\3\60\5\60\u01a5\n\60\3\60\3\60"+
		"\3\61\5\61\u01aa\n\61\3\61\3\61\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\65"+
		"\3\65\3\65\3\66\3\66\3\67\3\67\3\67\38\38\38\38\38\38\39\39\39\39\39\3"+
		"9\39\39\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3<\3<\3<\3"+
		"=\3=\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?\3?\3?\3@\3@\3"+
		"@\3@\3@\3A\3A\3A\3A\3A\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3C\3C\3C\3C\3"+
		"D\3D\3D\3D\3E\3E\3E\3E\3E\3F\3F\3F\3F\3F\3F\3F\3G\3G\3G\3G\3G\3H\3H\3"+
		"H\3H\3H\3H\3H\3H\3H\3H\3H\3I\3I\3I\3I\3I\3I\3I\3J\3J\3J\3J\3J\3J\3J\3"+
		"K\3K\3K\3K\3L\3L\3L\3L\3L\3L\3M\3M\3M\3M\3M\3M\3N\3N\3N\3N\3N\3N\3O\3"+
		"O\3O\3O\3O\3O\3O\3P\3P\3P\3P\3P\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3R\3R\3R\3S\3S\3"+
		"S\3S\3S\3S\3S\3S\3S\3T\6T\u0271\nT\rT\16T\u0272\3U\5U\u0276\nU\3U\3U\3"+
		"V\6V\u027b\nV\rV\16V\u027c\3V\3V\2\2W\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\2\65\2\67\29\2;\2=\2?\2A\2C\2E\33G\34I\35K\36M\2O\2Q\2S"+
		"\2U\37W Y![\"]#_$a%c&e\'g(i)k*m+o,q-s.u/w\60y\61{\62}\63\177\64\u0081"+
		"\65\u0083\66\u0085\67\u00878\u00899\u008b:\u008d;\u008f<\u0091=\u0093"+
		">\u0095?\u0097@\u0099A\u009bB\u009dC\u009fD\u00a1E\u00a3F\u00a5G\u00a7"+
		"H\u00a9I\u00abJ\3\2\f\t\2WWiikkoouuwwzz\b\2\f\f\17\17,,\61\61]^\u202a"+
		"\u202b\7\2\f\f\17\17\61\61]^\u202a\u202b\6\2\f\f\17\17^_\u202a\u202b\5"+
		"\2\f\f\17\17\u202a\u202b\6\2\f\f\17\17))^^\n\2$$))^^ddhhppttvv\3\2\62"+
		";\5\2\62;C\\c|\4\2\13\13\"\"\2\u0293\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2"+
		"]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3"+
		"\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2"+
		"\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3"+
		"\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2"+
		"\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093"+
		"\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2"+
		"\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5"+
		"\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\3\u00ad\3\2\2"+
		"\2\5\u00b1\3\2\2\2\7\u00b4\3\2\2\2\t\u00b8\3\2\2\2\13\u00ba\3\2\2\2\r"+
		"\u00bc\3\2\2\2\17\u00be\3\2\2\2\21\u00c6\3\2\2\2\23\u00c9\3\2\2\2\25\u00d2"+
		"\3\2\2\2\27\u00d8\3\2\2\2\31\u00dc\3\2\2\2\33\u00e3\3\2\2\2\35\u00e6\3"+
		"\2\2\2\37\u00ea\3\2\2\2!\u00f0\3\2\2\2#\u00f5\3\2\2\2%\u00fc\3\2\2\2\'"+
		"\u0101\3\2\2\2)\u0106\3\2\2\2+\u0108\3\2\2\2-\u010a\3\2\2\2/\u010d\3\2"+
		"\2\2\61\u010f\3\2\2\2\63\u0114\3\2\2\2\65\u011e\3\2\2\2\67\u0121\3\2\2"+
		"\29\u0126\3\2\2\2;\u012b\3\2\2\2=\u012d\3\2\2\2?\u0130\3\2\2\2A\u013b"+
		"\3\2\2\2C\u013d\3\2\2\2E\u013f\3\2\2\2G\u0153\3\2\2\2I\u0155\3\2\2\2K"+
		"\u015b\3\2\2\2M\u0162\3\2\2\2O\u0168\3\2\2\2Q\u016a\3\2\2\2S\u016d\3\2"+
		"\2\2U\u0170\3\2\2\2W\u0174\3\2\2\2Y\u0185\3\2\2\2[\u0191\3\2\2\2]\u01a1"+
		"\3\2\2\2_\u01a4\3\2\2\2a\u01a9\3\2\2\2c\u01ad\3\2\2\2e\u01af\3\2\2\2g"+
		"\u01b2\3\2\2\2i\u01b4\3\2\2\2k\u01b7\3\2\2\2m\u01b9\3\2\2\2o\u01bc\3\2"+
		"\2\2q\u01c2\3\2\2\2s\u01ca\3\2\2\2u\u01cf\3\2\2\2w\u01d5\3\2\2\2y\u01de"+
		"\3\2\2\2{\u01e6\3\2\2\2}\u01ed\3\2\2\2\177\u01f3\3\2\2\2\u0081\u01f8\3"+
		"\2\2\2\u0083\u01fd\3\2\2\2\u0085\u0208\3\2\2\2\u0087\u020c\3\2\2\2\u0089"+
		"\u0210\3\2\2\2\u008b\u0215\3\2\2\2\u008d\u021c\3\2\2\2\u008f\u0221\3\2"+
		"\2\2\u0091\u022c\3\2\2\2\u0093\u0233\3\2\2\2\u0095\u023a\3\2\2\2\u0097"+
		"\u023e\3\2\2\2\u0099\u0244\3\2\2\2\u009b\u024a\3\2\2\2\u009d\u0250\3\2"+
		"\2\2\u009f\u0257\3\2\2\2\u00a1\u025c\3\2\2\2\u00a3\u0263\3\2\2\2\u00a5"+
		"\u0266\3\2\2\2\u00a7\u0270\3\2\2\2\u00a9\u0275\3\2\2\2\u00ab\u027a\3\2"+
		"\2\2\u00ad\u00ae\7c\2\2\u00ae\u00af\7p\2\2\u00af\u00b0\7f\2\2\u00b0\4"+
		"\3\2\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3\7t\2\2\u00b3\6\3\2\2\2\u00b4\u00b5"+
		"\7p\2\2\u00b5\u00b6\7q\2\2\u00b6\u00b7\7v\2\2\u00b7\b\3\2\2\2\u00b8\u00b9"+
		"\7*\2\2\u00b9\n\3\2\2\2\u00ba\u00bb\7+\2\2\u00bb\f\3\2\2\2\u00bc\u00bd"+
		"\7/\2\2\u00bd\16\3\2\2\2\u00be\u00bf\7d\2\2\u00bf\u00c0\7g\2\2\u00c0\u00c1"+
		"\7v\2\2\u00c1\u00c2\7y\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4\7g\2\2\u00c4"+
		"\u00c5\7p\2\2\u00c5\20\3\2\2\2\u00c6\u00c7\7k\2\2\u00c7\u00c8\7p\2\2\u00c8"+
		"\22\3\2\2\2\u00c9\u00ca\7e\2\2\u00ca\u00cb\7q\2\2\u00cb\u00cc\7p\2\2\u00cc"+
		"\u00cd\7v\2\2\u00cd\u00ce\7c\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0\7p\2\2"+
		"\u00d0\u00d1\7u\2\2\u00d1\24\3\2\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4\7"+
		"o\2\2\u00d4\u00d5\7r\2\2\u00d5\u00d6\7v\2\2\u00d6\u00d7\7{\2\2\u00d7\26"+
		"\3\2\2\2\u00d8\u00d9\7o\2\2\u00d9\u00da\7c\2\2\u00da\u00db\7z\2\2\u00db"+
		"\30\3\2\2\2\u00dc\u00dd\7n\2\2\u00dd\u00de\7g\2\2\u00de\u00df\7p\2\2\u00df"+
		"\u00e0\7i\2\2\u00e0\u00e1\7v\2\2\u00e1\u00e2\7j\2\2\u00e2\32\3\2\2\2\u00e3"+
		"\u00e4\7k\2\2\u00e4\u00e5\7u\2\2\u00e5\34\3\2\2\2\u00e6\u00e7\7j\2\2\u00e7"+
		"\u00e8\7g\2\2\u00e8\u00e9\7z\2\2\u00e9\36\3\2\2\2\u00ea\u00eb\7o\2\2\u00eb"+
		"\u00ec\7c\2\2\u00ec\u00ed\7v\2\2\u00ed\u00ee\7e\2\2\u00ee\u00ef\7j\2\2"+
		"\u00ef \3\2\2\2\u00f0\u00f1\7v\2\2\u00f1\u00f2\7j\2\2\u00f2\u00f3\7c\2"+
		"\2\u00f3\u00f4\7p\2\2\u00f4\"\3\2\2\2\u00f5\u00f6\7u\2\2\u00f6\u00f7\7"+
		"v\2\2\u00f7\u00f8\7c\2\2\u00f8\u00f9\7t\2\2\u00f9\u00fa\7v\2\2\u00fa\u00fb"+
		"\7u\2\2\u00fb$\3\2\2\2\u00fc\u00fd\7g\2\2\u00fd\u00fe\7p\2\2\u00fe\u00ff"+
		"\7f\2\2\u00ff\u0100\7u\2\2\u0100&\3\2\2\2\u0101\u0102\7y\2\2\u0102\u0103"+
		"\7k\2\2\u0103\u0104\7v\2\2\u0104\u0105\7j\2\2\u0105(\3\2\2\2\u0106\u0107"+
		"\7_\2\2\u0107*\3\2\2\2\u0108\u0109\7]\2\2\u0109,\3\2\2\2\u010a\u010b\7"+
		"\60\2\2\u010b\u010c\7\60\2\2\u010c.\3\2\2\2\u010d\u010e\7.\2\2\u010e\60"+
		"\3\2\2\2\u010f\u0110\7\61\2\2\u0110\u0111\5\63\32\2\u0111\u0112\7\61\2"+
		"\2\u0112\u0113\5\65\33\2\u0113\62\3\2\2\2\u0114\u0118\59\35\2\u0115\u0117"+
		"\5;\36\2\u0116\u0115\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118"+
		"\u0119\3\2\2\2\u0119\64\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011d\5\67\34"+
		"\2\u011c\u011b\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f"+
		"\3\2\2\2\u011f\66\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122\t\2\2\2\u0122"+
		"8\3\2\2\2\u0123\u0127\n\3\2\2\u0124\u0127\5=\37\2\u0125\u0127\5? \2\u0126"+
		"\u0123\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0125\3\2\2\2\u0127:\3\2\2\2"+
		"\u0128\u012c\n\4\2\2\u0129\u012c\5=\37\2\u012a\u012c\5? \2\u012b\u0128"+
		"\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012a\3\2\2\2\u012c<\3\2\2\2\u012d"+
		"\u012e\7^\2\2\u012e\u012f\5C\"\2\u012f>\3\2\2\2\u0130\u0134\7]\2\2\u0131"+
		"\u0133\5A!\2\u0132\u0131\3\2\2\2\u0133\u0136\3\2\2\2\u0134\u0132\3\2\2"+
		"\2\u0134\u0135\3\2\2\2\u0135\u0137\3\2\2\2\u0136\u0134\3\2\2\2\u0137\u0138"+
		"\7_\2\2\u0138@\3\2\2\2\u0139\u013c\n\5\2\2\u013a\u013c\5=\37\2\u013b\u0139"+
		"\3\2\2\2\u013b\u013a\3\2\2\2\u013cB\3\2\2\2\u013d\u013e\n\6\2\2\u013e"+
		"D\3\2\2\2\u013f\u0141\7)\2\2\u0140\u0142\5M\'\2\u0141\u0140\3\2\2\2\u0141"+
		"\u0142\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0144\7)\2\2\u0144F\3\2\2\2\u0145"+
		"\u0147\7/\2\2\u0146\u0145\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0148\3\2"+
		"\2\2\u0148\u0149\5U+\2\u0149\u014b\7\60\2\2\u014a\u014c\5U+\2\u014b\u014a"+
		"\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e"+
		"\u0154\3\2\2\2\u014f\u0151\7/\2\2\u0150\u014f\3\2\2\2\u0150\u0151\3\2"+
		"\2\2\u0151\u0152\3\2\2\2\u0152\u0154\5U+\2\u0153\u0146\3\2\2\2\u0153\u0150"+
		"\3\2\2\2\u0154H\3\2\2\2\u0155\u0156\5W,\2\u0156\u0157\7/\2\2\u0157\u0158"+
		"\5Y-\2\u0158\u0159\7/\2\2\u0159\u015a\5[.\2\u015aJ\3\2\2\2\u015b\u015c"+
		"\5]/\2\u015c\u015d\7<\2\2\u015d\u015e\5_\60\2\u015e\u015f\7<\2\2\u015f"+
		"\u0160\5a\61\2\u0160L\3\2\2\2\u0161\u0163\5O(\2\u0162\u0161\3\2\2\2\u0163"+
		"\u0164\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165N\3\2\2\2"+
		"\u0166\u0169\n\7\2\2\u0167\u0169\5Q)\2\u0168\u0166\3\2\2\2\u0168\u0167"+
		"\3\2\2\2\u0169P\3\2\2\2\u016a\u016b\7^\2\2\u016b\u016c\t\b\2\2\u016cR"+
		"\3\2\2\2\u016d\u016e\t\t\2\2\u016eT\3\2\2\2\u016f\u0171\5S*\2\u0170\u016f"+
		"\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173"+
		"V\3\2\2\2\u0174\u0175\5S*\2\u0175\u0176\5S*\2\u0176\u0177\5S*\2\u0177"+
		"\u0178\5S*\2\u0178X\3\2\2\2\u0179\u017b\7\62\2\2\u017a\u0179\3\2\2\2\u017a"+
		"\u017b\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u0186\5S*\2\u017d\u017e\7\63"+
		"\2\2\u017e\u0184\7\62\2\2\u017f\u0180\7\63\2\2\u0180\u0184\7\63\2\2\u0181"+
		"\u0182\7\63\2\2\u0182\u0184\7\64\2\2\u0183\u017d\3\2\2\2\u0183\u017f\3"+
		"\2\2\2\u0183\u0181\3\2\2\2\u0184\u0186\3\2\2\2\u0185\u017a\3\2\2\2\u0185"+
		"\u0183\3\2\2\2\u0186Z\3\2\2\2\u0187\u0189\4\62\64\2\u0188\u0187\3\2\2"+
		"\2\u0188\u0189\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u0192\5S*\2\u018b\u018c"+
		"\7\65\2\2\u018c\u0190\7\62\2\2\u018d\u018e\7\65\2\2\u018e\u0190\7\63\2"+
		"\2\u018f\u018b\3\2\2\2\u018f\u018d\3\2\2\2\u0190\u0192\3\2\2\2\u0191\u0188"+
		"\3\2\2\2\u0191\u018f\3\2\2\2\u0192\\\3\2\2\2\u0193\u0195\4\62\63\2\u0194"+
		"\u0193\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u01a2\5S"+
		"*\2\u0197\u0198\7\64\2\2\u0198\u01a0\7\62\2\2\u0199\u019a\7\64\2\2\u019a"+
		"\u01a0\7\63\2\2\u019b\u019c\7\64\2\2\u019c\u01a0\7\64\2\2\u019d\u019e"+
		"\7\64\2\2\u019e\u01a0\7\65\2\2\u019f\u0197\3\2\2\2\u019f\u0199\3\2\2\2"+
		"\u019f\u019b\3\2\2\2\u019f\u019d\3\2\2\2\u01a0\u01a2\3\2\2\2\u01a1\u0194"+
		"\3\2\2\2\u01a1\u019f\3\2\2\2\u01a2^\3\2\2\2\u01a3\u01a5\4\62\67\2\u01a4"+
		"\u01a3\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7\5S"+
		"*\2\u01a7`\3\2\2\2\u01a8\u01aa\4\62\67\2\u01a9\u01a8\3\2\2\2\u01a9\u01aa"+
		"\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ac\5S*\2\u01acb\3\2\2\2\u01ad\u01ae"+
		"\7?\2\2\u01aed\3\2\2\2\u01af\u01b0\7#\2\2\u01b0\u01b1\7?\2\2\u01b1f\3"+
		"\2\2\2\u01b2\u01b3\7>\2\2\u01b3h\3\2\2\2\u01b4\u01b5\7>\2\2\u01b5\u01b6"+
		"\7?\2\2\u01b6j\3\2\2\2\u01b7\u01b8\7@\2\2\u01b8l\3\2\2\2\u01b9\u01ba\7"+
		"@\2\2\u01ba\u01bb\7?\2\2\u01bbn\3\2\2\2\u01bc\u01bd\7q\2\2\u01bd\u01be"+
		"\7n\2\2\u01be\u01bf\7f\2\2\u01bf\u01c0\7g\2\2\u01c0\u01c1\7t\2\2\u01c1"+
		"p\3\2\2\2\u01c2\u01c3\7{\2\2\u01c3\u01c4\7q\2\2\u01c4\u01c5\7w\2\2\u01c5"+
		"\u01c6\7p\2\2\u01c6\u01c7\7i\2\2\u01c7\u01c8\7g\2\2\u01c8\u01c9\7t\2\2"+
		"\u01c9r\3\2\2\2\u01ca\u01cb\7v\2\2\u01cb\u01cc\7t\2\2\u01cc\u01cd\7w\2"+
		"\2\u01cd\u01ce\7g\2\2\u01cet\3\2\2\2\u01cf\u01d0\7h\2\2\u01d0\u01d1\7"+
		"c\2\2\u01d1\u01d2\7n\2\2\u01d2\u01d3\7u\2\2\u01d3\u01d4\7g\2\2\u01d4v"+
		"\3\2\2\2\u01d5\u01d6\7n\2\2\u01d6\u01d7\7g\2\2\u01d7\u01d8\7c\2\2\u01d8"+
		"\u01d9\7r\2\2\u01d9\u01da\7{\2\2\u01da\u01db\7g\2\2\u01db\u01dc\7c\2\2"+
		"\u01dc\u01dd\7t\2\2\u01ddx\3\2\2\2\u01de\u01df\7n\2\2\u01df\u01e0\7g\2"+
		"\2\u01e0\u01e1\7c\2\2\u01e1\u01e2\7r\2\2\u01e2\u01e3\7f\2\2\u01e3\u01e4"+
		"\7c\2\2\u01e4\u01e5\7{\2\2\u01e5z\3\2\2\2\u01e6\u01e7\7f\2\2\u01e7\u01e8"+
		"\7q\2\2\u01e8\u01e9\7o\2\2\u01e9\u01ea\7c\2\2\u01ea\u01eb\7k\2\2\u01eb"+
		"\u01ec\7p\2\2\u01ec|\3\2\2\2\u01ed\u01ee\7g\2\2\u01ee\u01ef\7o\2\2\u01ef"+
		"\u01f0\7c\2\2\u01f0\u01f1\7k\2\2\u01f1\u01f2\7n\2\2\u01f2~\3\2\2\2\u01f3"+
		"\u01f4\7k\2\2\u01f4\u01f5\7r\2\2\u01f5\u01f6\7x\2\2\u01f6\u01f7\7\66\2"+
		"\2\u01f7\u0080\3\2\2\2\u01f8\u01f9\7k\2\2\u01f9\u01fa\7r\2\2\u01fa\u01fb"+
		"\7x\2\2\u01fb\u01fc\78\2\2\u01fc\u0082\3\2\2\2\u01fd\u01fe\7r\2\2\u01fe"+
		"\u01ff\7t\2\2\u01ff\u0200\7k\2\2\u0200\u0201\7x\2\2\u0201\u0202\7c\2\2"+
		"\u0202\u0203\7v\2\2\u0203\u0204\7g\2\2\u0204\u0205\7a\2\2\u0205\u0206"+
		"\7k\2\2\u0206\u0207\7r\2\2\u0207\u0084\3\2\2\2\u0208\u0209\7w\2\2\u0209"+
		"\u020a\7t\2\2\u020a\u020b\7n\2\2\u020b\u0086\3\2\2\2\u020c\u020d\7O\2"+
		"\2\u020d\u020e\7C\2\2\u020e\u020f\7E\2\2\u020f\u0088\3\2\2\2\u0210\u0211"+
		"\7K\2\2\u0211\u0212\7O\2\2\u0212\u0213\7G\2\2\u0213\u0214\7K\2\2\u0214"+
		"\u008a\3\2\2\2\u0215\u0216\7K\2\2\u0216\u0217\7O\2\2\u0217\u0218\7G\2"+
		"\2\u0218\u0219\7K\2\2\u0219\u021a\7U\2\2\u021a\u021b\7X\2\2\u021b\u008c"+
		"\3\2\2\2\u021c\u021d\7K\2\2\u021d\u021e\7U\2\2\u021e\u021f\7D\2\2\u021f"+
		"\u0220\7P\2\2\u0220\u008e\3\2\2\2\u0221\u0222\7r\2\2\u0222\u0223\7g\2"+
		"\2\u0223\u0224\7t\2\2\u0224\u0225\7e\2\2\u0225\u0226\7g\2\2\u0226\u0227"+
		"\7p\2\2\u0227\u0228\7v\2\2\u0228\u0229\7c\2\2\u0229\u022a\7i\2\2\u022a"+
		"\u022b\7g\2\2\u022b\u0090\3\2\2\2\u022c\u022d\7d\2\2\u022d\u022e\7c\2"+
		"\2\u022e\u022f\7u\2\2\u022f\u0230\7g\2\2\u0230\u0231\78\2\2\u0231\u0232"+
		"\7\66\2\2\u0232\u0092\3\2\2\2\u0233\u0234\7p\2\2\u0234\u0235\7w\2\2\u0235"+
		"\u0236\7o\2\2\u0236\u0237\7d\2\2\u0237\u0238\7g\2\2\u0238\u0239\7t\2\2"+
		"\u0239\u0094\3\2\2\2\u023a\u023b\7k\2\2\u023b\u023c\7p\2\2\u023c\u023d"+
		"\7v\2\2\u023d\u0096\3\2\2\2\u023e\u023f\7h\2\2\u023f\u0240\7n\2\2\u0240"+
		"\u0241\7q\2\2\u0241\u0242\7c\2\2\u0242\u0243\7v\2\2\u0243\u0098\3\2\2"+
		"\2\u0244\u0245\7e\2\2\u0245\u0246\7q\2\2\u0246\u0247\7n\2\2\u0247\u0248"+
		"\7q\2\2\u0248\u0249\7t\2\2\u0249\u009a\3\2\2\2\u024a\u024b\7r\2\2\u024b"+
		"\u024c\7j\2\2\u024c\u024d\7q\2\2\u024d\u024e\7p\2\2\u024e\u024f\7g\2\2"+
		"\u024f\u009c\3\2\2\2\u0250\u0251\7o\2\2\u0251\u0252\7q\2\2\u0252\u0253"+
		"\7d\2\2\u0253\u0254\7k\2\2\u0254\u0255\7n\2\2\u0255\u0256\7g\2\2\u0256"+
		"\u009e\3\2\2\2\u0257\u0258\7W\2\2\u0258\u0259\7W\2\2\u0259\u025a\7K\2"+
		"\2\u025a\u025b\7F\2\2\u025b\u00a0\3\2\2\2\u025c\u025d\7i\2\2\u025d\u025e"+
		"\7d\2\2\u025e\u025f\7e\2\2\u025f\u0260\7q\2\2\u0260\u0261\7f\2\2\u0261"+
		"\u0262\7g\2\2\u0262\u00a2\3\2\2\2\u0263\u0264\7K\2\2\u0264\u0265\7F\2"+
		"\2\u0265\u00a4\3\2\2\2\u0266\u0267\7r\2\2\u0267\u0268\7c\2\2\u0268\u0269"+
		"\7u\2\2\u0269\u026a\7u\2\2\u026a\u026b\7r\2\2\u026b\u026c\7q\2\2\u026c"+
		"\u026d\7t\2\2\u026d\u026e\7v\2\2\u026e\u00a6\3\2\2\2\u026f\u0271\t\n\2"+
		"\2\u0270\u026f\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0270\3\2\2\2\u0272\u0273"+
		"\3\2\2\2\u0273\u00a8\3\2\2\2\u0274\u0276\7\17\2\2\u0275\u0274\3\2\2\2"+
		"\u0275\u0276\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u0278\7\f\2\2\u0278\u00aa"+
		"\3\2\2\2\u0279\u027b\t\13\2\2\u027a\u0279\3\2\2\2\u027b\u027c\3\2\2\2"+
		"\u027c\u027a\3\2\2\2\u027c\u027d\3\2\2\2\u027d\u027e\3\2\2\2\u027e\u027f"+
		"\bV\2\2\u027f\u00ac\3\2\2\2\37\2\u0118\u011e\u0126\u012b\u0134\u013b\u0141"+
		"\u0146\u014d\u0150\u0153\u0164\u0168\u0172\u017a\u0183\u0185\u0188\u018f"+
		"\u0191\u0194\u019f\u01a1\u01a4\u01a9\u0272\u0275\u027c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}