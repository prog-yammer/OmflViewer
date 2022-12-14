package org.mishandro.omfl.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.mishandro.omfl.OmflFileType;
import org.mishandro.omfl.OmflLanguage;
import org.jetbrains.annotations.NotNull;

public class OmflFile extends PsiFileBase {

    public OmflFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, OmflLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return OmflFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "OMFL File";
    }

}