package org.mishandro.omfl;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mishandro.omfl.psi.OmflTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OmflFoldingBuilder extends FoldingBuilderEx implements DumbAware {

    @Override
    public FoldingDescriptor @NotNull [] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        List<FoldingDescriptor> descriptors = new ArrayList<>();

        Collection<PsiElement> literalExpressions =
                PsiTreeUtil.findChildrenOfType(root, PsiElement.class);

        int StartOffsetSection = -1;
        int EndOffsetSection = -1;
        ASTNode lastSection = null;

        for (final PsiElement literalExpression : literalExpressions) {
            String value = literalExpression.getText() != null ? literalExpression.getText() : null;

            if (value != null && literalExpression.getNode().getElementType().equals(OmflTypes.SECTION)) {

                if (StartOffsetSection != -1 && StartOffsetSection != EndOffsetSection) {
                    descriptors.add(new FoldingDescriptor(lastSection,
                            new TextRange(StartOffsetSection, EndOffsetSection)));
                }

                StartOffsetSection = literalExpression.getTextRange().getStartOffset();
                EndOffsetSection = StartOffsetSection;

                lastSection = literalExpression.getNode();
            } else {
                if (literalExpression.getNode().getElementType().equals(OmflTypes.PROPERTY)) {
                    EndOffsetSection = literalExpression.getTextRange().getEndOffset();
                }
            }
        }

        if (StartOffsetSection != -1 && lastSection.getTextRange().getStartOffset() != EndOffsetSection) {
            descriptors.add(new FoldingDescriptor(lastSection,
                    new TextRange(StartOffsetSection, EndOffsetSection)));
        }

        return descriptors.toArray(new FoldingDescriptor[0]);
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        return node.getText();
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }

}