package org.jason5lee

case class TreeNode[T](data: T, children: Seq[TreeNode[T]] = Nil)

object Showtree extends App {
  def asciiDisplay(root: TreeNode[String]): Seq[String] = {
    def display(prefix: String, isLastChild: Boolean, root: TreeNode[String]): Seq[String] = {
      val rootStr = prefix ++ "+-" ++ root.data.toString
      root.children.reverse match {
        case Seq() => if (isLastChild) Seq(rootStr, prefix) else Seq(rootStr)
        case Seq(last, restRev @ _*) => {
          val childPrefix = prefix + (if (isLastChild) "  " else "| ")
          rootStr +: restRev.foldLeft(display(childPrefix, true, last)) { (result, child) =>
            display(childPrefix, false, child) ++: result
          }
        }
      }
    }
    display("", true, root)
  }
}
