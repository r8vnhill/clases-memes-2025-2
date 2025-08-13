def itHailstone(n: Int): Int =
  var r: Int = n
  while r != 1 do
    println(r)
    if r % 2 == 0 then r = r / 2
    else r = 3 * r + 1
  println(r)
  r

//noinspection NoTailRecursionAnnotation
def recHailstone(n: Int): Int =
  if n == 1 then
    println(n)
    n
  else
    println(n)
    if n % 2 == 0 then recHailstone(n / 2)
    else recHailstone(3 * n + 1)

@main def hailstones(): Unit =
  itHailstone(3)
  println("----")
  recHailstone(3)
