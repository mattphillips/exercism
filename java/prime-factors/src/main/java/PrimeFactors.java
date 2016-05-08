import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeFactors {

    private static final long FIRST_DIVISOR = 2;

    public static List<Long> getForNumber(final long naturalNumber) {
        return computePrimeFactors(Collections.emptyList(), naturalNumber, FIRST_DIVISOR);
    }

    private static List<Long> computePrimeFactors(
            final List<Long> primeFactors,
            final long naturalNumberRemainder,
            final long divisor
    ) {
        if (isRemainderOne(naturalNumberRemainder))
            return Collections.unmodifiableList(primeFactors);

        else if (isRemainderDivisibleByDivisor(naturalNumberRemainder, divisor))
            return Collections.unmodifiableList(computePrimeFactors(
                    new ArrayList<Long>(primeFactors) {{ add(divisor); }},
                    naturalNumberRemainder / divisor,
                    divisor
            ));

        else
            return Collections.unmodifiableList(computePrimeFactors(primeFactors, naturalNumberRemainder, divisor + 1));
    }

    private static boolean isRemainderOne(final long remainingNaturalNumber) {
        return remainingNaturalNumber == 1;
    }

    private static boolean isRemainderDivisibleByDivisor(final long remainder, final long divisor) {
        return remainder % divisor == 0;
    }
}
