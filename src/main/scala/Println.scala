package org.brianmckenna.nescala.warts

import org.brianmckenna.wartremover.{WartTraverser, WartUniverse}

object Println extends WartTraverser {
  def apply(u: WartUniverse): u.Traverser = {
    import u.universe._

    val predefSymbol = rootMirror.staticModule("scala.Predef")
    val PrintlnName: TermName = "println"

    new Traverser {
      override def traverse(tree: Tree) {
        tree match {
          case Select(left, PrintlnName) if left.tpe <:< predefSymbol.typeSignature =>
            u.error(tree.pos, "You used println! You're bad!!!")

          case _ =>
            super.traverse(tree)
        }
      }
    }
  }
}
