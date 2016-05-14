import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;

public class Crypto {

    private final String input;

    public Crypto(final String input) {
        this.input = input;
    }

    public String getNormalizedPlaintext() {
        return input.toLowerCase().replaceAll("[^\\dA-Za-z]+", "");
    }

    public int getSquareSize() {
        return (int) ceil(sqrt(getNormalizedPlaintext().length()));
    }

    public List<String> getPlaintextSegments() {
        return splitStringIntoGroups(getNormalizedPlaintext(), getSquareSize());
    }

    public String getCipherText() {
        return IntStream
                .range(0, getSquareSize())
                .mapToObj(i -> {
                    return getPlaintextSegments().stream()
                            .map(s -> s.length() > i ? String.valueOf(s.charAt(i)) : null)
                            .filter(s -> s != null)
                            .collect(Collectors.joining());
                }).collect(Collectors.joining());
    }

    public String getNormalizedCipherText() {
        String cipher = getCipherText();
        int cipherLength = cipher.length();

        int perfectGroupSize = getPlaintextSegments().size();

        int requiredSquares = cipherLength % perfectGroupSize == 0
                ? (cipherLength / perfectGroupSize)
                : (cipherLength / perfectGroupSize) + 1;
        int numberOfImperfectSquares = perfectGroupSize - cipherLength % perfectGroupSize;

        String perfectCipher = cipher.substring(0, (requiredSquares - numberOfImperfectSquares) * perfectGroupSize);
        String imperfectCipher = cipher.substring(perfectCipher.length());

        int imperfectGroupSize = imperfectCipher.length() / numberOfImperfectSquares;

        List<String> perfectSquares = splitStringIntoGroups(perfectCipher, perfectGroupSize);
        List<String> imperfectSquares = splitStringIntoGroups(imperfectCipher, imperfectGroupSize);

        return Stream.concat(
                perfectSquares.stream(),
                imperfectSquares.stream()
        ).collect(Collectors.joining(" "));
    }

    private List<String> splitStringIntoGroups(String str, int groupSize) {
        int range = str.length();
        return IntStream
                .range(0, range)
                .filter(i -> i % groupSize == 0)
                .mapToObj(i -> {
                    int upperBound = i + groupSize > range ? range : i + groupSize;
                    return str.substring(i, upperBound);
                })
                .collect(Collectors.toList());
    }
}
