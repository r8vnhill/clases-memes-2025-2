package cl.uchile.dcc.munit

import cl.uchile.dcc.Calculator

class CalculatorTest extends munit.FunSuite:
  var calculator: Calculator = null

  override def beforeEach(context: BeforeEach): Unit =
    calculator = new Calculator("Test Calculator")

  test("Test addition of two positive integers") {
      val result = calculator.add(2, 3)
      assertEquals(5, result)
  }
