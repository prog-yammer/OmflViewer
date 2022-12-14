package org.mishandro.omfl;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mishandro.omfl.psi.OmflTypes;

public class OmflPairedBraceMatcher implements PairedBraceMatcher {
    private final BracePair[] pairs = new BracePair[] {
            new BracePair(OmflTypes.OPEN_ARRAY, OmflTypes.CLOSE_ARRAY, false),
    };

    @Override
    public BracePair @NotNull [] getPairs() {
        return pairs;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull final IElementType lbraceType, @Nullable final IElementType contextType) {
        return true;
    }

    @Override
    public int getCodeConstructStart(final PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}