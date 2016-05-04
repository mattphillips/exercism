import java.util.stream.IntStream;

public class Binary {

    private static final String VALID_BINARY = "[01]+";

    private final int decimal;

    public Binary(final String binary) {
        if (binary.matches(VALID_BINARY)) {
            char[] binaryDigits = new StringBuilder(binary).reverse().toString().toCharArray();

            decimal = IntStream.range(0, binaryDigits.length)
                    .mapToObj(i -> Character.getNumericValue(binaryDigits[i]) * Math.pow(2, i))
                    .mapToInt(Double::intValue)
                    .sum();
        } else {
            decimal = 0;
        }
    }

    public int getDecimal() {
        return decimal;
    }
}
