package cl.uchile.dcc.junit

import cl.uchile.dcc.Calculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.{BeforeEach, DisplayName, Test}

class CalculatorTest:
  var calculator: Calculator = null

  @BeforeEach
  def setUp(): Unit =
      calculator = new Calculator("Test Calculator")

  @Test
  @DisplayName("Test addition of two positive integers")
  def testAddPositiveIntegers(): Unit =
    val result = calculator.add(2, 3)
    assertEquals(5, result)
