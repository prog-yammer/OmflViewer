// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.mishandro.omfl;

import com.intellij.psi.tree.IElementType;
import org.mishandro.omfl.psi.OmflTypes;
import com.intellij.psi.TokenType;
import com.intellij.lexer.FlexLexer;

%%

%class OmflLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\n
WHITE_SPACE=[\ \n\t\f]
OPEN_ARRAY=("\[")
CLOSE_ARRAY=("]")
COMMA=(",")

QUOTE=("\"") ((\\.) | [^\"\\])*

VALUE_STRING_CHARACTER=("\"") ((\\.) | [^\"\\])* ("\"")
VALUE_BOOL_CHARACTER=("true")|("false")
VALUE_NUM_CHARACTER=["+-"]?([\d]+(\.[\d]+)?)

KEY_CHARACTER=[\w\d\-_]

SECTION=\[ [\w\d\-_\.]+ ]

END_OF_LINE_COMMENT=("#")[^\r\n]*
SEPARATOR=[=]

%state WAITING_VALUE

%%

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return OmflTypes.COMMENT; }

<YYINITIAL> {KEY_CHARACTER}+                                { yybegin(YYINITIAL); return OmflTypes.KEY; }
<YYINITIAL> {SECTION}                                { yybegin(YYINITIAL); return OmflTypes.SECTION; }

<YYINITIAL> {SEPARATOR}                                     { yybegin(WAITING_VALUE); return OmflTypes.SEPARATOR; }
<WAITING_VALUE> {OPEN_ARRAY}                                     { yybegin(WAITING_VALUE); return OmflTypes.OPEN_ARRAY; }
{CLOSE_ARRAY}                                     { yybegin(YYINITIAL); return OmflTypes.CLOSE_ARRAY; }
<YYINITIAL> {COMMA}                                     { yybegin(WAITING_VALUE); return OmflTypes.COMMA; }
<WAITING_VALUE> {QUOTE}    { yybegin(YYINITIAL); return OmflTypes.QUOTE; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {VALUE_STRING_CHARACTER}    { yybegin(YYINITIAL); return OmflTypes.VALUE_STRING; }
<WAITING_VALUE> {VALUE_BOOL_CHARACTER}   { yybegin(YYINITIAL); return OmflTypes.VALUE_BOOL; }
<WAITING_VALUE> {VALUE_NUM_CHARACTER}   { yybegin(YYINITIAL); return OmflTypes.VALUE_NUM; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^]                                                         { return TokenType.BAD_CHARACTER; }