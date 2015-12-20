import java.util.stream.IntStream;

public class Hamming {
	
	public static int compute(final String s, final String t) {
		
		if (s.length() != t.length())
			throw new IllegalArgumentException();

		return IntStream
				.range(0, s.length())
				.map(i -> s.charAt(i) != t.charAt(i) ? 1 : 0)
				.sum();
	}
}