def calculateInterest(principal: Double, rate: Double, time: Int): Double =
  var varPrincipal = principal
  for i <- 1 to time do varPrincipal += varPrincipal * rate / 100
  varPrincipal

def totalAmount(principal: Double, rate: Double, time: Int): Double =
  principal + calculateInterest(principal, rate, time)

case class Position(x: Int, y: Int)
trait Screen
trait Shape:
  val tag: String
  val position: Position
  def displayOn(s: Screen): Unit


def displayShape(s: Shape): Unit =
  if s.tag == "Square" then ???
  else if s.tag == "Circle" then ???
  else if s.tag == "Triangle" then ???
  else if s.tag == "Rectangle" then ???
  /* ... */

@main def main(): Unit =
  if 2 + 2 == 4 then println("Hello, Scala 3!")
  else println()
