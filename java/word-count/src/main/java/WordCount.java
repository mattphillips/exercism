import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class WordCount {
	
	private static final String NOT_ALPHA_NUMERIC_DELIMITER = "[^a-zA-Z0-9']+";
	private static final String SENTENCE_DELIMITER = " ";
	private static final String ALPHA_NUMERIC = "[A-Za-z0-9]+";

	public Map<String, Integer> Phrase(String string) {

		Map<String, Integer> wordCount = new HashMap<>();
		
		String[] words = string.split(SENTENCE_DELIMITER);
		
		List<String> normalisedWords = normaliseWords(words);
		
		normalisedWords.stream().forEach(word -> {
			
			if (wordCount.containsKey(word)) {
				int currentCount = wordCount.get(word) + 1;
				wordCount.put(word, currentCount);
			
			} else {
				wordCount.put(word, 1);
			}
		});
		
		return wordCount;
	}

	private List<String> normaliseWords(String[] words) {
		
		List<String> normalisedWords = new ArrayList<>();
		
		for (String word : words) {
			word = word.toLowerCase();
			
			if (word.matches(ALPHA_NUMERIC)) {
				normalisedWords.add(word);
			} else {
				Optional<String> nw = findFirstValidWord(word);
				if (nw.isPresent())
					normalisedWords.add(nw.get());
			}
		}
		return normalisedWords;
	}

	private Optional<String> findFirstValidWord(String invalidWord) {
		
		String [] invalidContents = invalidWord.split(NOT_ALPHA_NUMERIC_DELIMITER);
		
		for (String c : invalidContents) {
			if (c.matches(ALPHA_NUMERIC)) {
				return Optional.of(c);
			}
		}
		return Optional.empty();
	}
}
