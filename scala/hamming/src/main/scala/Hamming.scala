object Hamming {
  def compute(s: String, t: String): Int = {
    if (s.length == t.length) s zip t count { case (a, b) => a != b }
    else throw new IllegalArgumentException()
  }
}
