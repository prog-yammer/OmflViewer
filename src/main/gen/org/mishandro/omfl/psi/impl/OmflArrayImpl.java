// This is a generated file. Not intended for manual editing.
package org.mishandro.omfl.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.mishandro.omfl.psi.OmflArray;
import org.mishandro.omfl.psi.OmflValue;
import org.mishandro.omfl.psi.OmflVisitor;

import java.util.List;

public class OmflArrayImpl extends ASTWrapperPsiElement implements OmflArray {

  public OmflArrayImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OmflVisitor visitor) {
    visitor.visitArray(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OmflVisitor) accept((OmflVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<OmflValue> getValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OmflValue.class);
  }

}
