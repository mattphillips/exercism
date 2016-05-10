import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Strain {

    public static <T> List<T> keep(final List<T> collection, final Predicate<T> predicate) {
        return Collections.unmodifiableList(filter(collection, predicate, Collections.emptyList()));
    }

    public static <T> List<T> discard(final List<T> collection, final Predicate<T> predicate) {
        return Collections.unmodifiableList(filter(collection, predicate.negate(), Collections.emptyList()));
    }

    private static <T> List<T> filter(final List<T> xs, final Predicate<T> p, final List<T> matched) {
        if (xs.isEmpty())
            return matched;

        T head = xs.get(0);
        List<T> tail = xs.subList(1, xs.size());

        if (p.test(head))
            return filter(tail, p, new ArrayList<T>(matched) {{ add(head); }});

        else
            return filter(tail, p, matched);
    }
}
