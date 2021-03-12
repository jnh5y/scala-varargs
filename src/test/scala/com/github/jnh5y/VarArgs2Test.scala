package com.github.jnh5y

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

import scala.AnyRef

@RunWith(classOf[JUnitRunner])
class VarArgs2Test extends Specification {

//  def func(inputs: Array[Object]) = {
//    println(s" Received ${inputs.size} inputs!")
//    inputs.foreach { println }
//    inputs.size
//  }

  def func(inputs: Object*) = {
    println(s" Received ${inputs.size} inputs!")
    inputs.foreach { println }
    inputs.size
  }

  sequential

  val unused = 3

  "VarArgs" should {
    "accept singleton or array values" in {
      func(Array[AnyRef]("foo", Int.box(1))) mustEqual 2
      func("foo") mustEqual 1
    }

    "work with objects" in {
      val objects: Array[AnyRef] = Array[AnyRef]("foo", new Integer(1))

      // This represents GT up to 24.0.
      // Prints:
      // Called arrayFunction with 2 inputs.
      //  Object 0:foo
      //  Object 1:1
      MyJavaClass.arrayFunction(objects)

      MyJavaClass.varargsFunction(new Integer(5))

      /*  New GeoTools code in 25-RC / 25.0 */
      // Prints:
      // Called varargsFunction with 1 inputs.
      //  Object 0:[Ljava.lang.Object;@6b12d449
      MyJavaClass.varargsFunction(objects)

      // The right way to call from Scala is
      MyJavaClass.varargsFunction(objects: _*)

      ok
    }

    "work with Integers" in {
      val integers = Array[Integer](new Integer(1), new Integer(5))

      // Both print:
      // Called arrayFunctionInteger with 2 inputs.
      //  Object 0:1
      //  Object 1:5

      MyJavaClass.arrayFunctionInteger(integers)

      // Note that the next line will not compile:
      // MyJavaClass.varargsFunctionInteger(integers)

      // This means that the change from Integer[] -> Integer... will surface as a compiler error.
      MyJavaClass.varargsFunctionInteger(integers: _*)

      ok
    }
  }

  def myBadFunction(): Int = {
    return 3
  }
}
