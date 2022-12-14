package org.mishandro.omfl;

import com.intellij.lang.Language;

public class OmflLanguage extends Language {

    public static final OmflLanguage INSTANCE = new OmflLanguage();

    private OmflLanguage() {
        super("Omfl");
    }

}