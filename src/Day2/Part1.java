package Day2;

import java.util.List;

import Common.Common;

public class Part1 {
	final String alphabet =
			"abcdefghijklmnopqrstuvwxyz";

	public static void main(String[] args) {
		new Part1().go();
	}

	void go() {
		List<String> lines =
				new Common().getPuzzleInput("src/Day2/input");
		int x = 0;
		int y = 0;

		/*
		 * Scan 1
		 */
		for (String line : lines) {
			if (contains(line, 2))
				x++;
		}

		/*
		 * Scan 2
		 */
		for (String line : lines) {
			if (contains(line, 3))
				y++;
		}

		System.out.println("Checksum: " + (x * y));
	}

	Integer countChars(final String s, final char c) {
		Integer count = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c)
				count++;
		}

		return count;
	}

	Boolean contains(final String line, final Integer howMany) {
		for (int i = 0; i < alphabet.length(); i++) {
			Integer count = countChars(line, alphabet.charAt(i));

			if (count == howMany)
				return true;
		}

		return false;
	}
}
