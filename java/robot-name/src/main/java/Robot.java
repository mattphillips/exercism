import java.util.HashSet;
import java.util.Random;
import java.util.Set;
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
	private Set<String> previousNames;
	
	public Robot() {
		name = generateName();
		previousNames = new HashSet<>();
	}

	public String getName() {
		return name;
	}

	public void reset() {
		previousNames.add(name);
		
		String temp = generateName();
		while (previousNames.contains(temp)) {
			temp = generateName();
		}
		name = temp;
	}

	private String generateName() {
		return String.join(
				EMPTY_DELIMITER, 
				generateRandomLetters(LETTER_RANGE_MIN, LETTER_RANGE_MAX, LENGTH_OF_SEQUENCE_OF_LETTERS, CAPITAL_A),
				generateRandomDigits(DIGIT_RANGE_MIN, DIGIT_RANGE_MAX, LENGTH_OF_SEQUENCE_OF_DIGITS));
	}

	private String generateRandomLetters(
			final int rangeMin, final int rangeMax, final int sequenceLength, char offset) {
		return generateSequenceFromMapper(rangeMin, rangeMax, sequenceLength, new IntFunction<String>() {
			@Override
			public String apply(int value) {
				return String.valueOf((char) (value + offset));
			}
		});
	}

	private String generateRandomDigits(final int rangeMin, final int rangeMax, final int sequenceLength) {
		return generateSequenceFromMapper(rangeMin, rangeMax, sequenceLength, new IntFunction<String>() {
			@Override
			public String apply(int value) {
				return String.valueOf(value);
			}
		});
	}

	private String generateSequenceFromMapper(
			final int rangeMin, final int rangeMax, final int sequenceLength, final IntFunction<String> intToStringMapper) {
		return new Random()
				.ints(rangeMin, rangeMax)
				.limit(sequenceLength)
				.mapToObj(intToStringMapper)
				.reduce((acc, next) -> String.join(EMPTY_DELIMITER, acc, next))
				.get();
	}
}