package psl.shortcleaner.utils;
/**
 * Code Taken from: https://github.com/larsga/Duke
 * License: Apache v2
 * Modified for use in my code
 */

import java.util.Set;
import java.util.HashSet;

public class QGram {

	public QGram() {
	}

	public boolean isTokenized() {
		return true;
	}

	public static double compare(String s1, String s2) {
		if (s1.equals(s2))
			return 1.0;

		Set<String> q1 = qgrams(s1);
		Set<String> q2 = qgrams(s2);

		if (q1.isEmpty() || q2.isEmpty())
			return 0.0; // division will fail

		int common = 0;
		for (String gram : q1)
			if (q2.contains(gram))
				common++;

		return overlap(common, q1, q2);
	}

	/**
	 * Produces basic q-grams, so that 'gail' -> 'ga', 'ai', 'il'.
	 */
	private static Set<String> qgrams(String s) {
		int q = 2;

		Set<String> grams = new HashSet<String>();
		for (int ix = 0; ix < s.length() - q + 1; ix++)
			grams.add(s.substring(ix, ix + q));

		return grams;
	}

	private static double overlap(int common, Set<String> q1, Set<String> q2) {
		return (double) common / Math.min((double) q1.size(), (double) q2.size());
	}
}
