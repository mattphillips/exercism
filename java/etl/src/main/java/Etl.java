import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etl {
	public Map<String, Integer> transform(Map<Integer, List<String>> old) {
		
		Map<String, Integer> newScoring = new HashMap<>();
		
		for (Integer key : old.keySet()) {

			for (String character : old.get(key)) {

				newScoring.put(character.toLowerCase(), key);
			}
		}

		return newScoring;
	}
}
