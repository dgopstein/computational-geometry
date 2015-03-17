object Heatmap4d {
  val sqr = Math.pow(_:Int, 2)
  type Point = (Int, Int, Int, Int)

  def heatmap4dIndex(points: Seq[Point]): Array[Array[Array[Array[Double]]]] = {
    val d = 5 // distance threshold (chosen arbitrarily)
    val t = 10 // size of output (chosen arbitrarily)

    val width = 32
    val height = 32

    val a = Array.ofDim[Double](width, height, width, height)

    for ((startX, startY, endX, endY) <- points) {
      for {x1 <- Range(0, width)
           y1 <- Range(0, height)
           x2 <- Range(0, width)
           y2 <- Range(0, height)} {

        val distance = Math.sqrt(
                   sqr(startX-x1)+
                   sqr(startY-y1)+
                   sqr(endX-x2) +
                   sqr(endY-y2))

          if (distance <= d)
            a(x1)(y1)(x2)(y2) = d - distance
      }
    }

    a
  }

  def ppStr(o: Any): String = o match {
    case a: Array[_] => a.map(ppStr).mkString("\n")
    case e => e.toString
  }
  
  def main(args: Array[(String)]) {
    val points = Seq((1, 2, 3, 4), (11, 12, 13, 14), (21, 22, 23, 24), (31, 32, 33, 34), (41, 42, 43, 44))
    println(heatmap4dIndex(points))
  }
}
