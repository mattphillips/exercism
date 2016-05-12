import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Atbash {

    private static final int GROUP_SIZE = 5;
    private static final String SPACES_AND_PUNCTIONAL = "\\s+|\\p{Punct}+";
    private static final char LOWERCASE_A = 'a';
    private static final char LOWERCASE_Z = 'z';

    public static String encode(final String plainText) {
        String encoded =  formatInput(plainText).chars()
                .mapToObj(c -> {
                    if (Character.isAlphabetic(c))
                        return String.valueOf(convert(LOWERCASE_A, LOWERCASE_Z, c));

                    return String.valueOf((char)c);
                }).collect(Collectors.joining());

        return IntStream.range(0, encoded.length())
                .filter(Atbash::isMultipleOfGroupSize)
                .mapToObj(i -> {
                    int groupSize = i + GROUP_SIZE > encoded.length() ? encoded.length() : i + GROUP_SIZE;
                    return encoded.substring(i, groupSize) + " ";
                }).collect(Collectors.joining()).trim();
    }

    public static String decode(final String cipherText) {
        return formatInput(cipherText).chars()
                .mapToObj(c -> {
                    if (Character.isAlphabetic(c))
                        return String.valueOf(convert(LOWERCASE_Z, LOWERCASE_A, c));

                    return String.valueOf((char) c);
                }).collect(Collectors.joining());
    }

    private static String formatInput(String input) {
        return input.toLowerCase().replaceAll(SPACES_AND_PUNCTIONAL, "");
    }

    private static char convert(int bottomOffset, int topOffset, int c) {
        int convertedChar = bottomOffset - c + topOffset;
        return (char) convertedChar;
    }

    private static boolean isMultipleOfGroupSize(int i) {
        return i % GROUP_SIZE == 0;
    }
}
