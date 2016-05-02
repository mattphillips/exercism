import java.util.Collections;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Scrabble {

    private final Map<Character, Integer> scoringSystem;
    private final int score;

    public Scrabble(String input) {
        scoringSystem = buildScoringSystem();

        if (input == null)
            score = 0;
        else
            score = input.chars()
                    .filter(Character::isLetter)
                    .map(Character::toUpperCase)
                    .mapToObj(c -> scoringSystem.get((char) c))
                    .mapToInt(Integer::intValue)
                    .sum();
    }

    public int getScore() {
        return score;
    }

    private Map<Character, Integer> buildScoringSystem() {
        return Collections.unmodifiableMap(
                Stream.of(
                        "AEIOULNRST".chars().mapToObj(c -> entry(c, 1)),
                        "DG".chars().mapToObj(c -> entry(c, 2)),
                        "BCMP".chars().mapToObj(c -> entry(c, 3)),
                        "FHVWY".chars().mapToObj(c -> entry(c, 4)),
                        "K".chars().mapToObj(c -> entry(c, 5)),
                        "JX".chars().mapToObj(c -> entry(c, 8)),
                        "QZ".chars().mapToObj(c -> entry(c, 10))
                )
                .flatMap(s -> s)
                .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue))
        );
    }

    private SimpleEntry<Character, Integer> entry(int key, int value) {
        return new SimpleEntry<>((char) key, value);
    }
}
