object Hamming {
  def compute(s: String, t: String): Int = {
    if (s.length == t.length) s zip t map { case (a: Char, b: Char) => if (a == b) 0 else 1 } sum
    else throw new IllegalArgumentException()
  }
}
