trait IPoint:
  val x: Int
  val y: Int

  def move(dx: Int, dy: Int): IPoint

class Point(
    override val x: Int,
    override val y: Int
) extends IPoint:
  def move(dx: Int, dy: Int): IPoint = Point(x + dx, y + dy)

  override def equals(obj: Any): Boolean =
    if obj.isInstanceOf[Point] then
      val other = obj.asInstanceOf[Point]
      x == other.x && y == other.y
    else false

class Rectangle(
    val origin: IPoint,
    val width: Int,
    val height: Int
):
  override def equals(obj: Any): Boolean =
    if obj.isInstanceOf[Rectangle] then
      val other = obj.asInstanceOf[Rectangle]
      origin == other.origin &&
      width == other.width &&
      height == other.height
    else false

  def move(dx: Int, dy: Int): Rectangle =
    new Rectangle(origin.move(dx, dy), width, height)

  def area: Int = width * height
