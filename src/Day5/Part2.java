package Day5;

import java.util.List;
import java.util.Random;

import Common.Common;

public class Part2 {
	public static void main(String[] args) {
		new Part2().go();
	}

	void fatal() {
		System.err.println("Fatal Error!");
		System.exit(1);
	}

	String getModifiedString(String in, char c1, char c2) {
		String puzzle = new String(in);
		char[] ar1 = { c1 };
		char[] ar2 = { c2 };

		puzzle = puzzle.replaceAll(new String(ar1), "");
		puzzle = puzzle.replaceAll(new String(ar2), "");

		return puzzle;
	}

	void go() {
		List<String> lines = new Common().getPuzzleInput("src/Day5/input");
		Random random = new Random(System.currentTimeMillis());
		final String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int length1 = Integer.MAX_VALUE;
		int length2 = Integer.MAX_VALUE;

		if (lines.size() != 1)
			fatal();

		final String puzzle = new String(lines.get(0));

		System.out.println("Please stand by while calculating the answer...");

		for (int i = 0; i < alphabet.length(); i++) {
			final char c1 = alphabet.charAt(i);
			final char c2 = Character.toUpperCase(c1);

			length1 = reactGetLength(getModifiedString(new String(puzzle), c1, c2));

			if (length1 < length2)
				length2 = length1;

			final int value = random.nextInt() % 2;
			System.out.print((value != 0) ? 'P' : 'p');
		}

		System.out.print('\n');
		System.out.println(length2);
	}

	int reactGetLength(final String in) {
		String puzzle = new String(in);
		int i = 0;

		while ((i + 1) < puzzle.length()) {
			final char c1 = puzzle.charAt(i);
			final char c2 = puzzle.charAt(i + 1);

			if (Character.isLowerCase(c1) && Character.isLowerCase(c2)) {
				i += 1;
			} else if (Character.isUpperCase(c1) && Character.isUpperCase(c2)) {
				i += 1;
			} else if (Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
				char[] array = { c1, c2 };

				puzzle = puzzle.replaceFirst(new String(array), "");
				i = 0;
			} else {
				i += 1;
			}
		}

		return puzzle.length();
	}
}
