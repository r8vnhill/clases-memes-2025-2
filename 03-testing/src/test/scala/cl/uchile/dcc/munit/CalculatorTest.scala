package cl.uchile.dcc.munit

class CalculatorTest extends munit.FunSuite:
  var calculator: Calculator = null

  override def beforeEach(context: BeforeEach): Unit =
    calculator = new Calculator()

  test("Test addition of two numbers") {
    assertEquals(5, calculator.add(2, 3), "2 + 3")
  }
