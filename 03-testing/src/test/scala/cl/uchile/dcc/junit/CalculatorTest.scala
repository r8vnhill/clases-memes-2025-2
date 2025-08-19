package cl.uchile.dcc.junit

import cl.uchile.dcc.Calculator
import org.junit.jupiter.api.BeforeEach

class CalculatorTest:
  var calculator: Option[Calculator] = None

  @BeforeEach
  def setUp(): Unit =
    calculator = new Calculator()

  @Test
  @DisplayName("Test addition of two numbers")
  def testAddition(): Unit =
    assertEquals(5, calculator.add(2, 3), "2 + 3")

