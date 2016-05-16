import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RnaTranscription {

    private static final Map<Character, String> DNA_TO_RNA = new HashMap<Character, String>() {{
        put('A', "U");
        put('C', "G");
        put('G', "C");
        put('T', "A");
    }};

    public static String ofDna(final String dna) {
        return dna.chars()
                .mapToObj(nucleotide -> DNA_TO_RNA.getOrDefault(Character.valueOf((char) nucleotide), ""))
                .collect(Collectors.joining());
    }
}
