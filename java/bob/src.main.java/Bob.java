public class Bob {

	private static final String EMPTY_IDENTIFIER = " ";
	private static final String SHOUTING_IDENTIFIER = "[A-Z\\d\\W]+[^\\d\\?][\\?]?";
	private static final String QUESTION_IDENTIFIER = "?";

	private static final String EMPTY_RESPONSE = "Fine. Be that way!";
	private static final String SHOUTING_RESPONSE = "Whoa, chill out!";
	private static final String QUESTION_RESPONSE = "Sure.";
	private static final String DEFAULT_RESPONSE = "Whatever.";

	public String hey(final String message) {

		if (isMessageEmpty(message))
			return EMPTY_RESPONSE;

		if (isMessageShouting(message))
			return SHOUTING_RESPONSE;

		if (isMessageQuestion(message))
			return QUESTION_RESPONSE;

		return DEFAULT_RESPONSE;
	}

	private boolean isMessageEmpty(final String message) {
		return message.replaceAll(EMPTY_IDENTIFIER, "").isEmpty();
	}

	private boolean isMessageShouting(final String message) {
		if ((message.contains("ä") || message.contains("ö") || message.contains("ü")))
			return false;

		return message.matches(SHOUTING_IDENTIFIER);
	}

	private boolean isMessageQuestion(final String message) {
		return message.endsWith(QUESTION_IDENTIFIER);
	}
}