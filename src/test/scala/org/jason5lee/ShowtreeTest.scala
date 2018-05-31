package org.jason5lee

import org.scalatest._
import Showtree.asciiDisplay

class ShowtreeTest extends FunSuite {
  test("Display a single TreeNode") {
    assert(asciiDisplay(TreeNode("Single Node")) == Seq("+-Single Node", ""))
  }
  test("Display a complex tree") {
    assert(
      asciiDisplay(TreeNode("Root",
                            children = List(TreeNode("level1-1"),
                                            TreeNode("level1-2"),
                                            TreeNode("level1-3")))) ==
        Seq("+-Root",
            "  +-level1-1",
            "  +-level1-2",
            "  +-level1-3",
            "  "))
    assert(
      asciiDisplay(TreeNode("Root",
                            children = List(
                              TreeNode("level1-1", children = TreeNode("level2-1", children = TreeNode("level3-1") :: Nil) :: Nil),
                              TreeNode("level1-2"),
                              TreeNode("level1-3")))) ==
        Seq("+-Root",
            "  +-level1-1",
            "  | +-level2-1",
            "  |   +-level3-1",
            "  |   ",
            "  +-level1-2",
            "  +-level1-3",
            "  "))
  }
}
