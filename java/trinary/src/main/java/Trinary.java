import java.util.stream.IntStream;

public class Trinary {

    private static final String VALID_TRIANRY_DIGITS = "[0-2]+";

    public static int toDecimal(String trinary) {
        if (trinary.matches(VALID_TRIANRY_DIGITS)) {
            char[] trinaryDigits = new StringBuilder(trinary).reverse().toString().toCharArray();

            return IntStream.range(0, trinaryDigits.length)
                    .mapToObj(i -> Character.getNumericValue(trinaryDigits[i]) * Math.pow(3, i))
                    .mapToInt(Double::intValue)
                    .sum();
        }
        return 0;
    }
}
