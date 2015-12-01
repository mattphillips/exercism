import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etl {
	public Map<String, Integer> transform(Map<Integer, List<String>> old) {
		
		Map<String, Integer> newScoring = new HashMap<>();
		
		for (Integer point : old.keySet()) {

			for (String letter : old.get(point)) {

				newScoring.put(letter.toLowerCase(), point);
			}
		}

		return newScoring;
	}
}
