import java.util.Random;
import java.util.function.IntFunction;

public class Robot {

	private static final String EMPTY_DELIMITER = "";

	private static final int LENGTH_OF_SEQUENCE_OF_LETTERS = 2;
	private static final int LENGTH_OF_SEQUENCE_OF_DIGITS = 3;

	private static final char CAPITAL_A = 'A';
	private static final int LETTER_RANGE_MIN = 0;
	private static final int LETTER_RANGE_MAX = 26;

	private static final int DIGIT_RANGE_MIN = 0;
	private static final int DIGIT_RANGE_MAX = 10;

	private String name;

	public Robot() {
		name = generateName();
	}

	public String getName() {
		return name.isEmpty() ? name = generateName() : name;
	}

	public void reset() {
		name = EMPTY_DELIMITER;
	}

	private String generateName() {
		return String.join(
				EMPTY_DELIMITER, 
				generateRandomLetters(LENGTH_OF_SEQUENCE_OF_LETTERS),
				generateRandomDigits(LENGTH_OF_SEQUENCE_OF_DIGITS));
	}

	private String generateRandomLetters(final int length) {
		return generateSequenceFromMapper(LETTER_RANGE_MIN, LETTER_RANGE_MAX, length, new IntFunction<String>() {
			@Override
			public String apply(int value) {
				return String.valueOf((char) (value + CAPITAL_A));
			}
		});
	}

	private String generateRandomDigits(final int length) {
		return generateSequenceFromMapper(DIGIT_RANGE_MIN, DIGIT_RANGE_MAX, length, new IntFunction<String>() {
			@Override
			public String apply(int value) {
				return String.valueOf(value);
			}
		});
	}

	private String generateSequenceFromMapper(
			final int min, final int max, final int length, final IntFunction<String> mapper) {
		return new Random()
				.ints(min, max)
				.limit(length)
				.mapToObj(mapper)
				.reduce((acc, next) -> String.join(EMPTY_DELIMITER, acc, next))
				.get();
	}
}