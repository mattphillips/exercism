import java.util.HashMap;
import java.util.Map;

public class WordCount {
	
	private static final String NOT_ALPHA_NUMERIC = "[^a-zA-Z0-9']+";
	private static final String WHITESPACE = " ";

	public Map<String, Integer> Phrase(String phrase) {

		Map<String, Integer> wordCount = new HashMap<>();
		
		String[] words = phrase.replaceAll(NOT_ALPHA_NUMERIC, WHITESPACE).toLowerCase().split(WHITESPACE);
		
		for (String word : words) {
			
			if (wordCount.containsKey(word)) {
				int newCount = wordCount.get(word) + 1;
				wordCount.put(word, newCount);
			
			} else {
				wordCount.put(word, 1);
			}
		}
		return wordCount;
	}
}