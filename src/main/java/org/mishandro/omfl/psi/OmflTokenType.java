package org.mishandro.omfl.psi;

import com.intellij.psi.tree.IElementType;
import org.mishandro.omfl.OmflLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class OmflTokenType extends IElementType {

    public OmflTokenType(@NotNull @NonNls String debugName) {
        super(debugName, OmflLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "OmflTokenType." + super.toString();
    }

}