package Day4;

class Time {
	private Integer month;
	private Integer day;
	private Integer hour;
	private Integer minute;

	Time(
			Integer month,
			Integer day,
			Integer hour,
			Integer minute) {
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}

	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}



	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}



	public Integer getHour() {
		return hour;
	}
	public void setHour(Integer hour) {
		this.hour = hour;
	}



	public Integer getMinute() {
		return minute;
	}
	public void setMinute(Integer minute) {
		this.minute = minute;
	}
}
