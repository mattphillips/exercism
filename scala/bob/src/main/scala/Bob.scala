class Bob {
  def hey(message: String) = message match {
    case silence if message.replaceAll(" ", "").isEmpty => "Fine. Be that way!"
    case shouting if message.matches("[A-Z\\d\\W]+[^\\d\\?][\\?]?") =>  "Whoa, chill out!"
    case question if message.endsWith("?") => "Sure."
    case _ => "Whatever."
  }
}
