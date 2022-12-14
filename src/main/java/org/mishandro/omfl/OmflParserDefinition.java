package org.mishandro.omfl;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.mishandro.omfl.parser.OmflParser;
import org.mishandro.omfl.psi.OmflFile;
import org.mishandro.omfl.psi.OmflTokenSets;
import org.mishandro.omfl.psi.OmflTypes;
import org.jetbrains.annotations.NotNull;

public class OmflParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(OmflLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new OmflLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return OmflTokenSets.COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new OmflParser();
    }

    @NotNull
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new OmflFile(viewProvider);
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return OmflTypes.Factory.createElement(node);
    }

}