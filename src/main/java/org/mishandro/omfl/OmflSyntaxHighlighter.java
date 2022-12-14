package org.mishandro.omfl;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.mishandro.omfl.psi.OmflTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class OmflSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("SIMPLE_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEY =
            createTextAttributesKey("SIMPLE_KEY", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey SECTION =
            createTextAttributesKey("SIMPLE_SECTION", DefaultLanguageHighlighterColors.STATIC_METHOD);
    public static final TextAttributesKey VALUE_STRING =
            createTextAttributesKey("SIMPLE_VALUE_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey VALUE_BOOL =
            createTextAttributesKey("SIMPLE_VALUE_BOOL", DefaultLanguageHighlighterColors.CONSTANT);

    public static final TextAttributesKey VALUE_NUM =
            createTextAttributesKey("SIMPLE_VALUE_NUM", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("SIMPLE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] SECTION_KEYS = new TextAttributesKey[]{SECTION};
    private static final TextAttributesKey[] VALUE_STRING_KEYS = new TextAttributesKey[]{VALUE_STRING};
    private static final TextAttributesKey[] VALUE_BOOL_KEYS = new TextAttributesKey[]{VALUE_BOOL};
    private static final TextAttributesKey[] VALUE_NUM_KEYS = new TextAttributesKey[]{VALUE_NUM};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new OmflLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(OmflTypes.SEPARATOR)) {
            return SEPARATOR_KEYS;
        }
        if (tokenType.equals(OmflTypes.SECTION)) {
            return SECTION_KEYS;
        }
        if (tokenType.equals(OmflTypes.KEY)) {
            return KEY_KEYS;
        }
        if (tokenType.equals(OmflTypes.VALUE_STRING) || tokenType.equals(OmflTypes.QUOTE)) {
            return VALUE_STRING_KEYS;
        }
        if (tokenType.equals(OmflTypes.VALUE_BOOL)) {
            return VALUE_BOOL_KEYS;
        }
        if (tokenType.equals(OmflTypes.VALUE_NUM)) {
            return VALUE_NUM_KEYS;
        }
        if (tokenType.equals(OmflTypes.COMMENT)) {
            return COMMENT_KEYS;
        }
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }

}