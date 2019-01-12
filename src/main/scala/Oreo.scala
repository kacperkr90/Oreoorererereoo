trait Layer {
  def getASCII: Char
  def layerLength(): Int
  def layerDecorator(): String => String
  override def toString: String = layerDecorator().apply(List.fill(layerLength())(getASCII).mkString)
}

case class OLayer(n: Int) extends Layer {
  override def getASCII: Char = '█'
  override def layerLength(): Int = n
  override def layerDecorator(): String => String = identity
}

case class ReLayer(n: Int) extends Layer {
  override def getASCII: Char = '░'
  override def layerLength(): Int = n - 2
  override def layerDecorator(): String => String = " " + _ + " "
}

object Oreo {
  def toCookieString(input: String): String = {
    val n = input.length
    input
      .filter(c => c !='e')
      .map(c => if (c == 'o') OLayer(n) else ReLayer(n))
      .map(layer => layer.toString)
      .mkString("\n")
  }
}