package geometry

trait IRectangle {
    def move(x: Int, y: Int): IRectangle
    def area(): Int
}
