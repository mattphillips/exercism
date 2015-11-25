import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etl {
	public Map<String, Integer> transform(Map<Integer, List<String>> old) {
		
		Map<String, Integer> newScoring = new HashMap<>();
		
		for (Integer key : old.keySet()) {

			for (String s : old.get(key)) {

				newScoring.put(s.toLowerCase(), key);
			}
		}

		return newScoring;
	}
}
