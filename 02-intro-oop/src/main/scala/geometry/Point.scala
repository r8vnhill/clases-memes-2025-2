package geometry

class Point(private var x: Int, private var y: Int):
    def move(dx: Int, dy: Int): Point = 
        new Point(x + dx, y + dy)
