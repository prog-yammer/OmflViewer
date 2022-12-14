// This is a generated file. Not intended for manual editing.
package org.mishandro.omfl.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class OmflVisitor extends PsiElementVisitor {

  public void visitArray(@NotNull OmflArray o) {
    visitPsiElement(o);
  }

  public void visitProperty(@NotNull OmflProperty o) {
    visitPsiElement(o);
  }

  public void visitValue(@NotNull OmflValue o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
