package Day1;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day1 {
	final Integer startFrequency = 0;

	public static void main(String[] args) {
		new Day1().go();
	}

	void go() {
		Charset cs = Charset.forName("UTF-8");
		Integer counter = startFrequency;
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
			}
		} catch (Exception ex) {
			System.err.println("Error: " + ex.getMessage());
			System.exit(1);
		}

		System.out.printf("Resulting frequency: %d\n", counter.intValue());
	}
}
