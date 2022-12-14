// This is a generated file. Not intended for manual editing.
package org.mishandro.omfl.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.mishandro.omfl.psi.OmflTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class OmflParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return simpleFile(b, l + 1);
  }

  /* ********************************************************** */
  // OPEN_ARRAY (value? (COMMA value)*)? CLOSE_ARRAY
  public static boolean array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array")) return false;
    if (!nextTokenIs(b, OPEN_ARRAY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_ARRAY);
    r = r && array_1(b, l + 1);
    r = r && consumeToken(b, CLOSE_ARRAY);
    exit_section_(b, m, ARRAY, r);
    return r;
  }

  // (value? (COMMA value)*)?
  private static boolean array_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1")) return false;
    array_1_0(b, l + 1);
    return true;
  }

  // value? (COMMA value)*
  private static boolean array_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = array_1_0_0(b, l + 1);
    r = r && array_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // value?
  private static boolean array_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_0")) return false;
    value(b, l + 1);
    return true;
  }

  // (COMMA value)*
  private static boolean array_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!array_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA value
  private static boolean array_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // property|COMMENT|SECTION
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = property(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, SECTION);
    return r;
  }

  /* ********************************************************** */
  // KEY SEPARATOR value
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    if (!nextTokenIs(b, KEY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KEY, SEPARATOR);
    r = r && value(b, l + 1);
    exit_section_(b, m, PROPERTY, r);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean simpleFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simpleFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // VALUE_STRING|VALUE_BOOL|VALUE_NUM|array
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = consumeToken(b, VALUE_STRING);
    if (!r) r = consumeToken(b, VALUE_BOOL);
    if (!r) r = consumeToken(b, VALUE_NUM);
    if (!r) r = array(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
