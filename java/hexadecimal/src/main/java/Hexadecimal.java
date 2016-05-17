import java.util.stream.IntStream;

public class Hexadecimal {

    private static final String VALID_HEX_DIGITS = "[0-9abcdef]+";

    public static int toDecimal(final String hex) {
        if (hex.matches(VALID_HEX_DIGITS)) {
            char[] hexDigitals = new StringBuilder(hex).reverse().toString().toCharArray();

            return IntStream.range(0, hexDigitals.length)
                    .mapToObj(i -> Character.getNumericValue(hexDigitals[i]) * Math.pow(16, i))
                    .mapToInt(Double::intValue)
                    .sum();
        }

        return 0;
    }
}
