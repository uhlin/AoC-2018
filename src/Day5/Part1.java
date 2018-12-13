package Day5;

import java.util.List;

import Common.Common;

public class Part1 {
	public static void main(String[] args) {
		new Part1().go();
	}

	void fatal() {
		System.err.println("Fatal Error!");
		System.exit(1);
	}

	void go() {
		List<String> lines = new Common().getPuzzleInput("src/Day5/input");

		if (lines.size() != 1)
			fatal();

		String puzzle = new String(lines.get(0));
		int i = 0;

		while ((i + 1) < puzzle.length()) {
			final char c1 = puzzle.charAt(i);
			final char c2 = puzzle.charAt(i + 1);

			if (Character.isLowerCase(c1) && Character.isLowerCase(c2)) {
				i += 1;
				continue;
			} else if (Character.isUpperCase(c1) && Character.isUpperCase(c2)) {
				i += 1;
				continue;
			} else if (Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
				char[] array = { c1, c2 };

				puzzle = puzzle.replaceFirst(new String(array), "");
				i = 0;
				continue;
			} else {
				i += 1;
			}
		}

		System.out.println(puzzle.length());
	}
}
