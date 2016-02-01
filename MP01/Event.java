package MP01;

public class Event {
	private Date date;// the date of the event
	private int start; // The start time/hour of the event. It must be a number
						// between 0-23)
	private int end; // (the end time/hour of the event. It must be a number
						// between 0-23
	private String description; // A description of the event

	public Event(Date date, int start, int end, String description) throws IllegalArgumentException {
		if (start > 23 || start < 0) {
			throw new IllegalArgumentException("out of bounds");
		}
		if (end > 23 || end < 0) {
			throw new IllegalArgumentException("out of bounds");
		}
		if (end < start) {
			throw new IllegalArgumentException("end greater than start");
		}

		this.date = date;
		this.start = start;
		this.end = end;
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return date.toString() + " " + start + "-" + end + ": " + description;
	}

	public boolean equals(Event other) {
		if (date.equals(other.getDate()) && start == other.getStart() && end == other.getEnd()
				&& description.equals(other.getDescription()))
			return true;
		else
			return false;
	}

}
