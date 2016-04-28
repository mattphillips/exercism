import java.util.*;
import java.util.stream.Collectors;
import java.util.AbstractMap.SimpleEntry;

public class School {

    private Map<Integer, Set<String>> db = new TreeMap<>();

    public Map<Integer, Set<String>> db() {
        return Collections.unmodifiableMap(db);
    }

    public void add(final String name, final int grade) {
        db.computeIfAbsent(grade, k -> new TreeSet<>()).add(name);
    }

    public Set<String> grade(final int grade) {
        return Collections.unmodifiableSet(db.getOrDefault(grade, Collections.emptySet()));
    }

    public Map<Integer, List<String>> sort() {
        return Collections.unmodifiableMap(
                db.entrySet().stream()
                        .map(entry -> new SimpleEntry<>(entry.getKey(), new ArrayList<>(entry.getValue())))
                        .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue))
        );
    }
}