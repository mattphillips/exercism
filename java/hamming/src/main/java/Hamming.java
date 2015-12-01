public class Hamming {
	
	public static int compute(final String s, final String t) {
		
		if (s.length() != t.length())
			throw new IllegalArgumentException();
		
		int distance = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i))
				distance++;
		}
		
		return distance;
	}
}