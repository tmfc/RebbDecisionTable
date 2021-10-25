// Generated from RebbDT.g4 by ANTLR 4.9
package tech.rebb.dt;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RebbDTParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RebbDTVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link RebbDTParser#unaryTests}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunction(RebbDTParser.DisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Conjunction}
	 * labeled alternative in {@link RebbDTParser#unaryTests}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(RebbDTParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleTest}
	 * labeled alternative in {@link RebbDTParser#unaryTests}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleTest(RebbDTParser.SingleTestContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NormalUnaryTest}
	 * labeled alternative in {@link RebbDTParser#unaryTest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalUnaryTest(RebbDTParser.NormalUnaryTestContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegationUnaryTest}
	 * labeled alternative in {@link RebbDTParser#unaryTest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegationUnaryTest(RebbDTParser.NegationUnaryTestContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IgnoreUnaryTest}
	 * labeled alternative in {@link RebbDTParser#unaryTest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnoreUnaryTest(RebbDTParser.IgnoreUnaryTestContext ctx);
	/**
	 * Visit a parse tree produced by {@link RebbDTParser#positiveUnaryTest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositiveUnaryTest(RebbDTParser.PositiveUnaryTestContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(RebbDTParser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Between}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetween(RebbDTParser.BetweenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code In}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn(RebbDTParser.InContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Contains}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContains(RebbDTParser.ContainsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotEmpty}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEmpty(RebbDTParser.NotEmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MaxLength}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxLength(RebbDTParser.MaxLengthContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Is}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIs(RebbDTParser.IsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IsHex}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsHex(RebbDTParser.IsHexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IsCustom}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsCustom(RebbDTParser.IsCustomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Match}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatch(RebbDTParser.MatchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AgeCompare}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgeCompare(RebbDTParser.AgeCompareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringPosition}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringPosition(RebbDTParser.StringPositionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Interval}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterval(RebbDTParser.IntervalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Array}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(RebbDTParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(RebbDTParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code number}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(RebbDTParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code date}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(RebbDTParser.DateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code time}
	 * labeled alternative in {@link RebbDTParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime(RebbDTParser.TimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RebbDTParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(RebbDTParser.ArrayLiteralContext ctx);
}