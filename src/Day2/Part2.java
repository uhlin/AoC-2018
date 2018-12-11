package Day2;

import java.util.List;

import Common.Common;

public class Part2 {
	public static void main(String[] args) {
		new Part2().go();
	}

	void go() {
		List<String> lines =
				new Common().getPuzzleInput("src/Day2/input");

		for (String str1 : lines) {
			for (String str2 : lines) {
				if (str1.equals(str2))
					continue;
				else if (differByOneChar(str1, str2)) {
					System.out.println(str1);
					System.out.println(str2);

					return;
				}
			}
		}

		System.err.println("Unable to find the right answer!");
		System.exit(1);
	}

	Boolean differByOneChar(String str1, String str2) {
		int hits = 0;

		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) == str2.charAt(i))
				hits++;
		}

		return ((str1.length() - 1 == hits) ? true : false);
	}
}
