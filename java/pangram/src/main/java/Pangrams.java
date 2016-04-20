import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pangrams {

    private static final int LOWERCASE_A = 'a';
    private static final int LOWERCASE_Z = 'z';

    public static boolean isPangram(String sentence) {
        Set<Character> characters = sentence.toLowerCase()
                .chars()
                .mapToObj(i -> (char)i)
                .map(Character::new)
                .collect(Collectors.toSet());

        return IntStream.rangeClosed(LOWERCASE_A, LOWERCASE_Z)
                .mapToObj(i -> (char)i)
                .map(characters::contains)
                .reduce((b1, b2) -> b1 && b2)
                .orElse(false);
    }
}
