// This is a generated file. Not intended for manual editing.
package org.mishandro.omfl.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.mishandro.omfl.psi.OmflArray;
import org.mishandro.omfl.psi.OmflValue;
import org.mishandro.omfl.psi.OmflVisitor;

public class OmflValueImpl extends ASTWrapperPsiElement implements OmflValue {

  public OmflValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OmflVisitor visitor) {
    visitor.visitValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OmflVisitor) accept((OmflVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public OmflArray getArray() {
    return findChildByClass(OmflArray.class);
  }

}
