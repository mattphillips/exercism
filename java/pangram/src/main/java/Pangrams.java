import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pangrams {

    private static final int LOWERCASE_A = 'a';
    private static final int LOWERCASE_Z = 'z';
    private static final int EXCLUSIVE_OFFSET = 1;

    public static boolean isPangram(String sentence) {
        Set<Character> characters = sentence.toLowerCase()
                .chars()
                .mapToObj(c -> (char)c)
                .map(Character::new)
                .collect(Collectors.toSet());

        return IntStream.range(LOWERCASE_A, LOWERCASE_Z + EXCLUSIVE_OFFSET)
                .mapToObj(c -> (char)c)
                .map(characters::contains)
                .reduce((b1, b2) -> b1 && b2)
                .orElse(false);
    }
}
