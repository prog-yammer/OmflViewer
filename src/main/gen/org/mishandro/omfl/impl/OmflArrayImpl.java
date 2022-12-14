// This is a generated file. Not intended for manual editing.
package org.mishandro.omfl.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.mishandro.omfl.psi.OmflTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.mishandro.omfl.psi.*;

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
