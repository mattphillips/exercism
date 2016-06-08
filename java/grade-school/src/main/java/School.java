import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.AbstractMap.SimpleEntry;

public class School {

    private Map<Integer, Set<String>> db = new TreeMap<>();

    public Map<Integer, Set<String>> db() {
        return buildUnmodifiableDb(
                entry -> new SimpleEntry<>(entry.getKey(), Collections.unmodifiableSet(entry.getValue()))
        );
    }

    public void add(final String name, final int grade) {
        db.computeIfAbsent(grade, k -> new TreeSet<>()).add(name);
    }

    public Set<String> grade(final int grade) {
        return Collections.unmodifiableSet(db.getOrDefault(grade, Collections.emptySet()));
    }

    public Map<Integer, List<String>> sort() {
        return buildUnmodifiableDb(
                entry -> new SimpleEntry<>(
                        entry.getKey(),
                        Collections.unmodifiableList(new ArrayList<>(entry.getValue()))
                )
        );
    }

    private <T> Map<Integer, T> buildUnmodifiableDb(
            final Function<Map.Entry<Integer, Set<String>>, SimpleEntry<Integer, T>> unmodifiableGradeMapper
    ) {
        return Collections.unmodifiableMap(
                db.entrySet().stream()
                        .map(unmodifiableGradeMapper::apply)
                        .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue)));
    }
}
