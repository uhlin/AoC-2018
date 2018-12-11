package Day4;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Common.Common;

public class Part1 {
	List<Guard> guards = null;
	List<String> lines = null;
	final Integer guardWithMostMinutesAsleep = 3209;

	public static void main(String[] args) {
		new Part1().go();
	}

	void go() {
		Integer month  = 0;
		Integer day    = 0;
		Integer hour   = 0;
		Integer minute = 0;
		Integer guardID = 0;
//		Time begunShift = null;
		Time fellAsleep = null;
		Time wokeUp = null;

		guards = new ArrayList<>();
		lines = new Common().getPuzzleInput("src/Day4/sorted-input");

		System.out.println("000000000011111111112222222222333333333344444444445555555555");
		System.out.println("012345678901234567890123456789012345678901234567890123456789");

		int counter = 0;

		for (String line : lines) {
			if (line.endsWith("begins shift")) {
				/*********************************************
				 *
				 * [YYYY-MM-DD HH:MM] Guard #<ID> begins shift
				 *
				 *********************************************/
				counter = 0;
				Pattern pattern = Pattern.compile(
						"\\[1518-(\\d+)-(\\d+) (\\d+):(\\d+)\\] " +
						"Guard #(\\d+) begins shift");
				Matcher matcher = pattern.matcher(line);
				if (!matcher.find() || matcher.groupCount() != 5)
					fatal();
				month  = Integer.parseInt(matcher.group(1));
				day    = Integer.parseInt(matcher.group(2));
				hour   = Integer.parseInt(matcher.group(3));
				minute = Integer.parseInt(matcher.group(4));
				guardID = Integer.parseInt(matcher.group(5));
				if (!guardIsKnown(guardID.intValue()))
					guards.add(new Guard(guardID));
//				begunShift = new Time(month, day, hour, minute);
			} else if (line.endsWith("falls asleep")) {
				/*********************************
				 *
				 * [YYYY-MM-DD HH:MM] falls asleep
				 *
				 *********************************/
				Pattern pattern = Pattern.compile(
						"\\[1518-(\\d+)-(\\d+) (\\d+):(\\d+)\\] " +
						"falls asleep");
				Matcher matcher = pattern.matcher(line);
				if (!matcher.find() || matcher.groupCount() != 4)
					fatal();
				month  = Integer.parseInt(matcher.group(1));
				day    = Integer.parseInt(matcher.group(2));
				hour   = Integer.parseInt(matcher.group(3));
				minute = Integer.parseInt(matcher.group(4));
				fellAsleep = new Time(month, day, hour, minute);
			} else if (line.endsWith("wakes up")) {
				/*****************************
				 *
				 * [YYYY-MM-DD HH:MM] wakes up
				 *
				 *****************************/
				Pattern pattern = Pattern.compile(
						"\\[1518-(\\d+)-(\\d+) (\\d+):(\\d+)\\] " +
						"wakes up");
				Matcher matcher = pattern.matcher(line);
				if (!matcher.find() || matcher.groupCount() != 4)
					fatal();
				month  = Integer.parseInt(matcher.group(1));
				day    = Integer.parseInt(matcher.group(2));
				hour   = Integer.parseInt(matcher.group(3));
				minute = Integer.parseInt(matcher.group(4));
				wokeUp = new Time(month, day, hour, minute);
				Guard guard = findGuardByID(guardID.intValue());
				if (guard == null)
					fatal();
				int diff = wokeUp.getMinute() - fellAsleep.getMinute();
				while (diff != 0) {
					guard.increaseMinutesAsleep();
					diff--;
				}

				/* -------------------------------------------------- */

				if (guard.getId().equals(guardWithMostMinutesAsleep)) {
					if (counter == 0)
						System.out.print('\n');

					while (counter < fellAsleep.getMinute()) {
						System.out.print('.');
						counter++;
					}

					diff = wokeUp.getMinute() - fellAsleep.getMinute();

					while (diff != 0) {
						counter++;
						diff--;
						System.out.print('#');
					}
				}
			} else {
				fatal();
			} /* if-then-else */
		} /* for */

		System.out.print('\n');

		Guard guard = findGuardWithMostMinutesAsleep();
		System.out.println(
				"Guard with most minutes asleep: " +
				guard.getId());
		// 3209
	} /* go() */

	void fatal() {
		System.err.println("Fatal Error!");
		System.exit(1);
	}

	Boolean guardIsKnown(int id) {
		for (Guard guard : guards) {
			if (guard.getId().intValue() == id)
				return true;
		}
		return false;
	}

	Guard findGuardByID(int id) {
		for (Guard guard : guards) {
			if (guard.getId().intValue() == id)
				return guard;
		}
		return null;
	}

	Guard findGuardWithMostMinutesAsleep() {
		Integer id = 0;
		Integer minutesAsleep = 0;

		for (Guard guard : guards) {
			if (guard.getMinutesAsleep() > minutesAsleep) {
				id = guard.getId();
				minutesAsleep = guard.getMinutesAsleep();
			}
		}

		return findGuardByID(id.intValue());
	}
}
