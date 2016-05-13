import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Accumulate {
    public static <T, R> List<R> accumulate(List<T> collection, Function<T, R> operation) {
        return map(collection, operation).collect(Collectors.toList());
    }

    public static <T, R> Stream<R> map(final List<T> xs, final Function<T, R> f) {
        if (xs.isEmpty())
            return Stream.empty();

        R head = f.apply(xs.get(0));
        List<T> tail = xs.subList(1, xs.size());

        return Stream.concat(
                Stream.of(head),
                map(tail, f)
        );
    }
}
