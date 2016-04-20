import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pangrams {

    private static final int A_ASCII = 97;
    private static final int Z_ASCII = 122;
    private static final int EXCLUSIVE_OFFSET = 1;

    public static boolean isPangram(String sentence) {
        Set<Character> characters = sentence.toLowerCase()
                .chars()
                .mapToObj(c -> (char)c)
                .map(Character::new)
                .collect(Collectors.toSet());

        return IntStream.range(A_ASCII, Z_ASCII + EXCLUSIVE_OFFSET)
                .mapToObj(c -> (char)c)
                .map(c -> characters.contains(new Character(c)))
                .reduce((b1, b2) -> b1 && b2)
                .orElse(false);
    }
}
