package recursion

import org.scalatest.FunSuite
import recursion.TailRecursiveSum.sum

class TailRecursiveSumTests extends FunSuite {
    
    test("a simple case works") {
        val x = sum(List(1,2,3,4))
        assert(x == 10)
    }

    test("100,000 integers") {
        assertResult(705082704) {
            val list = (1 to 100000).toList
            sum(list)
        }
    }

    test("negative numbers") {
        val x = sum(List(-1,-2,-3,-4))
        assert(x == -10)
    }

    test("Empty lists are 0") {
        // a few ways of saying the same thing
        assert(sum(List()) == 0)
        assertResult(0) {
            val x: List[Int] = List()
            sum(x)
        }
        assertResult(0) {
            val x: List[Int] = Nil
            sum(x)
        }
    }

}

