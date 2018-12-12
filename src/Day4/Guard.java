package Day4;

class Guard {
	private static final int ASLEEP_ARRAY_SIZE = 59;

	private Integer id;
	private Integer minutesAsleep;
	private int[] asleep;

	Guard(Integer id) {
		this.id = id;
		this.minutesAsleep = 0;
		this.asleep = new int[ASLEEP_ARRAY_SIZE];
		for (int i = 0; i < ASLEEP_ARRAY_SIZE; i++)
			(asleep[i]) = 0;
	}

	public int getHits() {
		int hits = 0;

		for (int i = 0; i < ASLEEP_ARRAY_SIZE; i++) {
			if (asleep[i] > hits)
				hits = asleep[i];
		}

		return hits;
	}

	public int minuteMostFrequentlyAsleep() {
		int hits = 0;
		int i;

		for (i = 0; i < ASLEEP_ARRAY_SIZE; i++) {
			if (asleep[i] > hits)
				hits = asleep[i];
		}

		for (i = 0; i < ASLEEP_ARRAY_SIZE; i++) {
			if (asleep[i] == hits)
				break;
		}

		return i;
	}

	/* ---------------------------------------- */

	public void increaseMinuteHitsFor(final int whichMinute) {
		for (int i = 0; i < ASLEEP_ARRAY_SIZE; i++) {
			if (i == whichMinute) {
				(asleep[i]) ++;
				return;
			}
		}

		System.err.println("increaseMinuteHitsFor() error");
		System.exit(1);
	}
	public void decreaseMinuteHitsFor(final int whichMinute) {
		for (int i = 0; i < ASLEEP_ARRAY_SIZE; i++) {
			if (i == whichMinute) {
				(asleep[i]) --;
				return;
			}
		}

		System.err.println("decreaseMinuteHitsFor() error");
		System.exit(1);
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getMinutesAsleep() {
		return minutesAsleep;
	}
	public void setMinutesAsleep(Integer minutesAsleep) {
		this.minutesAsleep = minutesAsleep;
	}


	public void decreaseMinutesAsleep() {
		this.minutesAsleep--;
	}
	public void increaseMinutesAsleep() {
		this.minutesAsleep++;
	}
}
