package Day4;

class Guard {
	private Integer id;
	private Integer minutesAsleep;

	Guard(Integer id) {
		this.id = id;
		this.minutesAsleep = 0;
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
