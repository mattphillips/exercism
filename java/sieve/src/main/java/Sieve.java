import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sieve {

    private final List<Integer> primes;

    public Sieve(final int limit) {
        this.primes = filterPrimes(
                IntStream.rangeClosed(2, limit).mapToObj(Integer::valueOf).collect(Collectors.toList()),
                Collections.emptyList()
        );
    }

    private List<Integer> filterPrimes(final List<Integer> range, final List<Integer> primes) {
        if (range.isEmpty())
            return Collections.unmodifiableList(primes);

        int head = range.get(0);

        return filterPrimes(
                range.stream().filter(i -> i % head != 0 ).collect(Collectors.toList()),
                new ArrayList<Integer>(primes) {{ add(head); }}
        );
    }

    public List<Integer> getPrimes() {
        return Collections.unmodifiableList(primes);
    }
}
