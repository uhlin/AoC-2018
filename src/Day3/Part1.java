package Day3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Common.Common;

public class Part1 {
	public static void main(String[] args) {
		new Part1().go();
	}

	void go() {
		List<Claim> claims = getClaims();

		for (Claim c : claims) {
			outputClaim(c);
		}
	}

	List<Claim> getClaims() {
		List<Claim> claims = new ArrayList<Claim>();
		List<String> lines =
				new Common().getPuzzleInput("src/Day3/input");

		/*
		 * #1 @ 1,3: 4x4
		 * #2 @ 3,1: 4x4
		 * #3 @ 5,5: 2x2
		 */
		for (String line : lines) {
			Pattern pattern =
				Pattern.compile("#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)");
			Matcher matcher = pattern.matcher(line);

			if (!matcher.find() || matcher.groupCount() != 5) {
				System.err.println("fatal error");
				System.exit(1);
			}

			Claim claim = new Claim(
					Integer.parseInt(matcher.group(1)),
					Integer.parseInt(matcher.group(2)),
					Integer.parseInt(matcher.group(3)),
					Integer.parseInt(matcher.group(4)),
					Integer.parseInt(matcher.group(5)));

			claims.add(claim);
		}

		return claims;
	}

	void outputClaim(Claim c) {
		System.out.println("------------------------------");
		System.out.println("claimID:        " + c.getClaimID());
		System.out.println("From left edge: " + c.getInchesFromLeftEdge());
		System.out.println("From top edge:  " + c.getInchesFromTopEdge());
		System.out.println("Wide:           " + c.getInchesWide());
		System.out.println("Tall:           " + c.getInchesTall());
	}
}

class Claim {
	private Integer claimID;
	private Integer inchesFromLeftEdge;
	private Integer inchesFromTopEdge;
	private Integer inchesWide;
	private Integer inchesTall;

	public Claim(
			Integer claimID,
			Integer inchesFromLeftEdge,
			Integer inchesFromTopEdge,
			Integer inchesWide,
			Integer inchesTall) {
		this.claimID = claimID;
		this.inchesFromLeftEdge = inchesFromLeftEdge;
		this.inchesFromTopEdge = inchesFromTopEdge;
		this.inchesWide = inchesWide;
		this.inchesTall = inchesTall;
	}

	public Integer getClaimID() {
		return claimID;
	}
	public Integer getInchesFromLeftEdge() {
		return inchesFromLeftEdge;
	}
	public Integer getInchesFromTopEdge() {
		return inchesFromTopEdge;
	}
	public Integer getInchesWide() {
		return inchesWide;
	}
	public Integer getInchesTall() {
		return inchesTall;
	}
}
