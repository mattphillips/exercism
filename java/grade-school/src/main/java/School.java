import java.util.*;
import java.util.stream.Collectors;
import java.util.AbstractMap.SimpleEntry;

public class School {

    private Map<Integer, List<String>> db = new HashMap<>();

    public Map<Integer, List<String>> db() {
        return Collections.unmodifiableMap(db);
    }

    public void add(final String name, final int grade) {
        if (db.containsKey(grade))
            db.get(grade).add(name);
        else
            db.put(grade, new ArrayList<>(Collections.singletonList(name)));
    }

    public List<String> grade(final int grade) {
        return Collections.unmodifiableList(db.getOrDefault(grade, Collections.emptyList()));
    }

    public Map<Integer, List<String>> sort() {
        return Collections.unmodifiableMap(
                db.entrySet().stream()
                        .map(entry ->
                                new SimpleEntry<>(
                                        entry.getKey(),
                                        entry.getValue().stream()
                                                .sorted()
                                                .collect(Collectors.toList())
                                )
                        )
                        .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue))
        );
    }
}