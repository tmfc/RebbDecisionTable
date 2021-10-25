// Generated from RebbDT.g4 by ANTLR 4.9
package tech.rebb.dt;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RebbDTParser}.
 */
public interface RebbDTListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link RebbDTParser#unaryTests}.
	 * @param ctx the parse tree
	 */
	void enterDisjunction(RebbDTParser.DisjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link RebbDTParser#unaryTests}.
	 * @param ctx the parse tree
	 */
	void exitDisjunction(RebbDTParser.DisjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Conjunction}
	 * labeled alternative in {@link RebbDTParser#unaryTests}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(RebbDTParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Conjunction}
	 * labeled alternative in {@link RebbDTParser#unaryTests}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(RebbDTParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleTest}
	 * labeled alternative in {@link RebbDTParser#unaryTests}.
	 * @param ctx the parse tree
	 */
	void enterSingleTest(RebbDTParser.SingleTestContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleTest}
	 * labeled alternative in {@link RebbDTParser#unaryTests}.
	 * @param ctx the parse tree
	 */
	void exitSingleTest(RebbDTParser.SingleTestContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NormalUnaryTest}
	 * labeled alternative in {@link RebbDTParser#unaryTest}.
	 * @param ctx the parse tree
	 */
	void enterNormalUnaryTest(RebbDTParser.NormalUnaryTestContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NormalUnaryTest}
	 * labeled alternative in {@link RebbDTParser#unaryTest}.
	 * @param ctx the parse tree
	 */
	void exitNormalUnaryTest(RebbDTParser.NormalUnaryTestContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegationUnaryTest}
	 * labeled alternative in {@link RebbDTParser#unaryTest}.
	 * @param ctx the parse tree
	 */
	void enterNegationUnaryTest(RebbDTParser.NegationUnaryTestContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegationUnaryTest}
	 * labeled alternative in {@link RebbDTParser#unaryTest}.
	 * @param ctx the parse tree
	 */
	void exitNegationUnaryTest(RebbDTParser.NegationUnaryTestContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IgnoreUnaryTest}
	 * labeled alternative in {@link RebbDTParser#unaryTest}.
	 * @param ctx the parse tree
	 */
	void enterIgnoreUnaryTest(RebbDTParser.IgnoreUnaryTestContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IgnoreUnaryTest}
	 * labeled alternative in {@link RebbDTParser#unaryTest}.
	 * @param ctx the parse tree
	 */
	void exitIgnoreUnaryTest(RebbDTParser.IgnoreUnaryTestContext ctx);
	/**
	 * Enter a parse tree produced by {@link RebbDTParser#positiveUnaryTest}.
	 * @param ctx the parse tree
	 */
	void enterPositiveUnaryTest(RebbDTParser.PositiveUnaryTestContext ctx);
	/**
	 * Exit a parse tree produced by {@link RebbDTParser#positiveUnaryTest}.
	 * @param ctx the parse tree
	 */
	void exitPositiveUnaryTest(RebbDTParser.PositiveUnaryTestContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCompare(RebbDTParser.CompareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCompare(RebbDTParser.CompareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Between}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBetween(RebbDTParser.BetweenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Between}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBetween(RebbDTParser.BetweenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code In}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIn(RebbDTParser.InContext ctx);
	/**
	 * Exit a parse tree produced by the {@code In}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIn(RebbDTParser.InContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Contains}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterContains(RebbDTParser.ContainsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Contains}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitContains(RebbDTParser.ContainsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotEmpty}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotEmpty(RebbDTParser.NotEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotEmpty}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotEmpty(RebbDTParser.NotEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MaxLength}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMaxLength(RebbDTParser.MaxLengthContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MaxLength}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMaxLength(RebbDTParser.MaxLengthContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Is}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIs(RebbDTParser.IsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Is}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIs(RebbDTParser.IsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IsHex}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIsHex(RebbDTParser.IsHexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IsHex}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIsHex(RebbDTParser.IsHexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IsCustom}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIsCustom(RebbDTParser.IsCustomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IsCustom}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIsCustom(RebbDTParser.IsCustomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Match}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMatch(RebbDTParser.MatchContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Match}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMatch(RebbDTParser.MatchContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AgeCompare}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAgeCompare(RebbDTParser.AgeCompareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AgeCompare}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAgeCompare(RebbDTParser.AgeCompareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringPosition}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringPosition(RebbDTParser.StringPositionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringPosition}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringPosition(RebbDTParser.StringPositionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Interval}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInterval(RebbDTParser.IntervalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Interval}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInterval(RebbDTParser.IntervalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Array}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArray(RebbDTParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Array}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArray(RebbDTParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterString(RebbDTParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitString(RebbDTParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumber(RebbDTParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumber(RebbDTParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code date}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDate(RebbDTParser.DateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code date}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDate(RebbDTParser.DateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code time}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTime(RebbDTParser.TimeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code time}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTime(RebbDTParser.TimeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RebbDTParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(RebbDTParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link RebbDTParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(RebbDTParser.ArrayLiteralContext ctx);
}