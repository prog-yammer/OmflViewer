package org.mishandro.omfl.psi;

import com.intellij.psi.tree.TokenSet;

public interface OmflTokenSets {

    TokenSet IDENTIFIERS = TokenSet.create(OmflTypes.KEY);

    TokenSet COMMENTS = TokenSet.create(OmflTypes.COMMENT);

}