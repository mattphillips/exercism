import java.util.stream.Stream;

public class Raindrops {

    private static final int THREE_PRIME_FACTOR = 3;
    private static final int FIVE_PRIME_FACTOR = 5;
    private static final int SEVEN_PRIME_FACTOR = 7;

    private static final String THREE_PRIME_FACTOR_RAINDROP = "Pling";
    private static final String FIVE_PRIME_FACTOR_RAINDROP = "Plang";
    private static final String SEVEN_PRIME_FACTOR_RAINDROP = "Plong";

    public static String convert(int number) {
        return Stream.of(
                convertNumberToRaindropIfContainingPrimeFactor(number, THREE_PRIME_FACTOR, THREE_PRIME_FACTOR_RAINDROP),
                convertNumberToRaindropIfContainingPrimeFactor(number, FIVE_PRIME_FACTOR, FIVE_PRIME_FACTOR_RAINDROP),
                convertNumberToRaindropIfContainingPrimeFactor(number, SEVEN_PRIME_FACTOR, SEVEN_PRIME_FACTOR_RAINDROP))
                .filter(s -> !s.isEmpty())
                .reduce(String::concat)
                .orElse(String.valueOf(number));
    }

    private static String convertNumberToRaindropIfContainingPrimeFactor(
            final int number,
            final int primeFactor,
            final String raindrop) {
        if (number % primeFactor == 0)
            return raindrop;

        return "";
    }
}
