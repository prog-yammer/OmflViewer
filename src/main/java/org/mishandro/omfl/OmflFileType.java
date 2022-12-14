package org.mishandro.omfl;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.Icon;

public class OmflFileType extends LanguageFileType {

    public static final OmflFileType INSTANCE = new OmflFileType();

    private OmflFileType() {
        super(OmflLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Omfl File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "OneMoreFunnyLanguage file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "omfl";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return OmflIcons.FILE;
    }

}