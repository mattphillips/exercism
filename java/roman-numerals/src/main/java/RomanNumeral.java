import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RomanNumeral {

    private static final String ONE = "I";
    private static final String FIVE = "V";
    private static final String TEN = "X";
    private static final String FIFTY = "L";
    private static final String ONE_HUNDRED = "C";
    private static final String FIVE_HUNDRED = "D";
    private static final String ONE_THOUSAND = "M";
    private static final String FIVE_THOUSAND = "V";
    private static final String TEN_THOUSAND = "L";

    private final String romanNumeral;

    public RomanNumeral(int number) {
        romanNumeral = buildRomanNumeral(number);
    }

    private String buildRomanNumeral(int number) {
        List<Integer> numberUnits = String.valueOf(number).chars()
                .map(Character::getNumericValue)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());
        Collections.reverse(numberUnits);

        return IntStream.range(0, numberUnits.size())
                .mapToObj(i -> {
                    int unit = numberUnits.get(i);
                    if (i == 0)
                        return getOnes(unit);

                    if (i == 1)
                        return getTens(unit);

                    if (i == 2)
                        return getHundreds(unit);

                    if (i == 3)
                        return getThousands(unit);

                    return "";
                })
                .reduce((acc, next) -> next + acc).get();
    }

    private String getOnes(int number) {
        return convert(number, ONE, FIVE, TEN);
    }

    private String getTens(int number) {
        return convert(number, TEN, FIFTY, ONE_HUNDRED);
    }

    private String getHundreds(int number) {
        return convert(number, ONE_HUNDRED, FIVE_HUNDRED, ONE_THOUSAND);
    }

    private String getThousands(int number) {
        return convert(number, ONE_THOUSAND, FIVE_THOUSAND, TEN_THOUSAND);
    }

    private String convert(int number, String unit, String unitTimesFive, String unitTimesTen) {
        if (number == 1 || number == 2 || number == 3)
            return IntStream.rangeClosed(1, number).mapToObj(i -> unit).collect(Collectors.joining());

        if (number == 4)
            return unit + unitTimesFive;

        if (number == 5)
            return unitTimesFive;

        if (number == 6 || number == 7 || number == 8)
            return unitTimesFive + convert(number - 5, unit, unitTimesFive, unitTimesTen);

        if (number == 9)
            return unit + unitTimesTen;

        return "";
    }

    public String getRomanNumeral() {
        return romanNumeral;
    }
}
