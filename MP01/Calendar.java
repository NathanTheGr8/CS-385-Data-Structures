package MP01;

public class Calendar {
	static final int MAXEVENTS = 4; // A constant representing the maximum
									// number of events that can be stored. Make
									// it just 4 to support easy testing!
	Event[] events; // An array holding the scheduled events, of size MAXEVENTS.
					// If you don’t remember how to initialize an array and
					// access its elements
	int numEvents; // The number of events currently scheduled (i.e., the number
					// of entries in the “events” array)

	public Calendar() {
		events = new Event[MAXEVENTS];
		numEvents = 0;
	}

	// Adds an event to the events array if array is not ful
	// (numEvents==MAXEVENTS). It returns true if the event is successfully
	// added and false otherwise. If the array is not already full, you should
	// traverse the array and insert the event in place of the first null entry.
	// Don’t forget to increment the “numEvents” if an event is added
	// successfully.
	boolean addEvent(Event e) {
		if (!(numEvents >= MAXEVENTS)) {
			// add
			for (int i = 0; i < MAXEVENTS; i++) {
				if (events[i] == null) {
					events[i] = e;
					numEvents++;
					break;
				}
			}
			return true;
		} else
			return false;
	}

	// traverses the “events” array to look for an event that is equal to “e”.
	// If such event
	// is found, then the index of it in the array is returned. Otherwise, “-1”
	// is returned. Note that the array may
	// contain null entries so before checking for equality, make sure that the
	// array entry is not null otherwise
	// your program may throw a NullPointerException.
	int findEvent(Event e) {
		int toReturn = -1;
		for (int i = 0; i < MAXEVENTS; i++) {
			if (events[i] != null) {
				if (e.equals(events[i])) {
					toReturn = i;
				}
			}
		}
		return toReturn;
	}

	// removes an event from the array and returns true if the remove
	// operation is successful and false otherwise. Your method should first
	// call FindEvent to retrieve the index
	// of the array entry that contains the event. If FindEvent returns -1 then
	// the event does not exist in the
	// array and your method should return false. Otherwise, your method should
	// set the array entry to null.
	boolean removeEvent(Event e) {
		int index = findEvent(e);
		if (index != -1) {
			events[index] = null;
			numEvents--;
			// // Need to down shift events above this index
			// for (int i = index + 1; i < MAXEVENTS; i++) {
			// if (events[i] != null) {
			// events[i - 1] = events[i];
			// }
			// }
			// events[MAXEVENTS - 1] = null;
			return true;
		} else {
			return false;
		}
	}

	// Prints all the events in the calendar (i.e. all non-null entries in the
	// “events” array). Each
	// event should be printed in a separate line.
	void dump() {
		for (int i = 0; i < MAXEVENTS; i++) {
			if (events[i] != null) {
				System.out.println(events[i]);
			}
		}
	}
}
