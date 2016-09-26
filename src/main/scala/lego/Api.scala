package lego

object Api {
  type Transform = List[Double] => List[Double]
  type Algorithm = List[Double] => Double
  type Read = Unit => List[Double]
  type Write = Double => Unit
}
