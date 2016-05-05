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
            return primeFactors;

        else if (isRemainderDivisibleByDivisor(naturalNumberRemainder, divisor))
            return computePrimeFactors(
                    new ArrayList<Long>(primeFactors) {{ add(divisor); }},
                    naturalNumberRemainder / divisor,
                    divisor
            );

        else
            return computePrimeFactors(primeFactors, naturalNumberRemainder, divisor + 1);
    }

    private static boolean isRemainderOne(final long remainingNaturalNumber) {
        return remainingNaturalNumber == 1;
    }

    private static boolean isRemainderDivisibleByDivisor(final long remainder, final long divisor) {
        return remainder % divisor == 0;
    }
}
