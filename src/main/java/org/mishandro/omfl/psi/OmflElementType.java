package org.mishandro.omfl.psi;

import com.intellij.psi.tree.IElementType;
import org.mishandro.omfl.OmflLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class OmflElementType extends IElementType {

    public OmflElementType(@NotNull @NonNls String debugName) {
        super(debugName, OmflLanguage.INSTANCE);
    }

}