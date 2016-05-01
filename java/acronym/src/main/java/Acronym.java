import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Acronym {
    public static String generate(String phrase) {
        List<String> words = Arrays.asList(phrase.split("(\\W+|[a-z](?=[A-Z]))"));

        return words.stream()
                .map(word -> word.substring(0, 1))
                .collect(Collectors.joining())
                .toUpperCase();
    }
}
