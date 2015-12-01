import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Anagram {

	private final String word;

	public Anagram(final String word) {
		this.word = word;
	}

	public List<String> match(final List<String> possibleAnagrams) {
		return possibleAnagrams.stream()
				.filter(pa -> !(word.equalsIgnoreCase(pa))) // filter if the possible anagram is not identical to the word
				.filter(x -> sortString(word).equals(sortString(x))) // filter if the word and anagram are equal
				.collect(Collectors.toList());
	}

	private String sortString(final String str) {
		char[] strChars = str.toLowerCase().toCharArray();
		Arrays.sort(strChars);
		return new String(strChars);
	}
}