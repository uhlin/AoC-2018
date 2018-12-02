package Day1;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day1 {
	Boolean didOutputPart1 = false;
	Boolean partTwoDone = false;
	Integer counter = 0;
	List<Integer> frequencies = new ArrayList<>();

	public static void main(String[] args) {
		new Day1().go();
	}

	void go() {
		while (!partTwoDone)
			readfile();
	}

	void readfile() {
		Charset cs = Charset.forName("UTF-8");
		Path puzzleInput = Paths.get("src/Day1/input");

		try {
			List<String> lines = Files.readAllLines(puzzleInput, cs);

			for (String line : lines) {
				Integer i = Integer.parseInt(line.substring(1));

				if (line.charAt(0) == '+') {
					counter += i;
				} else if (line.charAt(0) == '-') {
					counter -= i;
				} else {
					throw new Exception("Unexpected puzzle data");
				}

				if (!partTwoDone) {
					if (frequencies.contains(counter)) {
						System.out.println("Part 2: " + counter);
						partTwoDone = true;
					} else {
						frequencies.add(counter);
					}
				}
			}
		} catch (Exception ex) {
			System.err.println("Error: " + ex.getMessage());
			System.exit(1);
		}

		if (!didOutputPart1) {
			System.out.printf("Resulting frequency: %d\n", counter.intValue());
			didOutputPart1 = true;
		}
	}
}
