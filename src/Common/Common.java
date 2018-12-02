package Common;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Common {
	public List<String> getPuzzleInput(String path) {
		Charset cs = Charset.forName("UTF-8");
		Path puzzleInput = Paths.get(path);

		try {
			return (Files.readAllLines(puzzleInput, cs));
		} catch (Exception ex) {
			System.err.println("getPuzzleInput: error: " + ex);
			System.exit(1);
		}

		return null;
	}
}
