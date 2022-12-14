// This is a generated file. Not intended for manual editing.
package org.mishandro.omfl.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.mishandro.omfl.impl.*;

public interface OmflTypes {

  IElementType ARRAY = new OmflElementType("ARRAY");
  IElementType PROPERTY = new OmflElementType("PROPERTY");
  IElementType VALUE = new OmflElementType("VALUE");

  IElementType CLOSE_ARRAY = new OmflTokenType("CLOSE_ARRAY");
  IElementType COMMA = new OmflTokenType("COMMA");
  IElementType COMMENT = new OmflTokenType("COMMENT");
  IElementType KEY = new OmflTokenType("KEY");
  IElementType OPEN_ARRAY = new OmflTokenType("OPEN_ARRAY");
  IElementType SECTION = new OmflTokenType("SECTION");
  IElementType SEPARATOR = new OmflTokenType("SEPARATOR");
  IElementType QUOTE = new OmflTokenType("QUOTE");
  IElementType VALUE_BOOL = new OmflTokenType("VALUE_BOOL");
  IElementType VALUE_NUM = new OmflTokenType("VALUE_NUM");
  IElementType VALUE_STRING = new OmflTokenType("VALUE_STRING");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARRAY) {
        return new OmflArrayImpl(node);
      }
      else if (type == PROPERTY) {
        return new OmflPropertyImpl(node);
      }
      else if (type == VALUE) {
        return new OmflValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
