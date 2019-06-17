import java.util
import java.util.EmptyStackException

import org.scalatest.FunSpec

class StackSpec extends FunSpec {

  describe("A Stack") {

    it("should pop values in last-in-first-out order") {
      val stack = new util.Stack[Int]
      stack.push(1)
      stack.push(2)
      assert(stack.pop() === 2)
      assert(stack.pop() === 1)
    }

    it("should throw EmptyStackException if an empty stack is popped") {
      val emptyStack = new util.Stack[String]
      intercept[EmptyStackException] {
        emptyStack.pop()
      }
    }
  }

}