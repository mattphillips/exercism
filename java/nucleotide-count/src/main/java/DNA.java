import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DNA {
	
	private static final int INITIAL_COUNT = 0;
	private static final char ADENINE = 'A';
	private static final char CYTOSINE = 'C';
	private static final char GUANINE = 'G';
	private static final char THYMINE = 'T';
	
	private final Map<Character, Integer> nucleotideCounts;

	public DNA(final String dna) {
		nucleotideCounts = initialiseCounts();
		countNucletidesInDna(dna);
	}

	public int count(final char nucleotide) throws IllegalArgumentException {
		
		if (nucleotideCounts.containsKey(nucleotide)) {
			return nucleotideCounts.get(nucleotide);
		}
		throw new IllegalArgumentException();
	}

	public Map<Character, Integer> nucleotideCounts() {
		return nucleotideCounts;
	}
	
	private Map<Character, Integer> initialiseCounts() {
		return (Map<Character, Integer>) Stream.of(
				new SimpleEntry<>(ADENINE, INITIAL_COUNT),
                new SimpleEntry<>(CYTOSINE, INITIAL_COUNT),
                new SimpleEntry<>(GUANINE, INITIAL_COUNT),
                new SimpleEntry<>(THYMINE, INITIAL_COUNT))
				.collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue()));
	}
	
	private void countNucletidesInDna(final String dna) {
		for (char c : dna.toCharArray()) {
			int tempCount = nucleotideCounts.get(c) + 1;
			nucleotideCounts.put(c, tempCount);
		}
	}
}