package org.mishandro.omfl;

import com.intellij.lexer.FlexAdapter;

public class OmflLexerAdapter extends FlexAdapter {

    public OmflLexerAdapter() {
        super(new OmflLexer(null));
    }

}