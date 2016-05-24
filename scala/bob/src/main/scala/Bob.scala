class Bob {
  val Silence = """(\s*)""".r
  val Shouting = """([A-Z\d\W]+[^\d\?][\?]?)""".r
  val Question = """(.*\?$)""".r

  def hey(message: String) = message match {
    case Silence(message) => "Fine. Be that way!"
    case Shouting(message) => "Whoa, chill out!"
    case Question(message) => "Sure."
    case _ => "Whatever."
  }
}
