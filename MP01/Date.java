package MP01;

public class Date implements Comparable<Date> {

	private int year; // 2014-2020
	private int month; // 1-12
	private int day; // 1-31

	public Date(int year, int month, int day) throws IllegalArgumentException {
		if (year > 2020 || year < 2014) {
			throw new IllegalArgumentException("out of bounds");
		}
		if (month > 12 || month < 1) {
			throw new IllegalArgumentException("out of bounds");
		}
		if (day > 31 || day < 1) {
			throw new IllegalArgumentException("out of bounds");
		}
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public int compareTo(Date other) {
		if (year != other.getYear()) {
			return Integer.compare(year, other.getYear());
		} else if (month != other.getMonth()) {
			return Integer.compare(month, other.getMonth());
		} else {
			return Integer.compare(day, other.getDay());
		}
	}

	public String toString() {
		return month + "/" + day + "/" + year;
	}

	public Boolean equals(Date other) {
		if (year == other.getYear() && month == other.getMonth() && day == other.getDay())
			return true;
		else
			return false;
	}

}
