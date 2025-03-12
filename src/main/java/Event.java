/**
 * Represents an Event task with a description, a "from" string, and a "to" string.
 */
public class Event extends Task {
    private String from;
    private String to;

    /**
     * Constructs an Event with the given description, from-string, and to-string.
     *
     * @param description The task description.
     * @param from The start time/place.
     * @param to The end time/place.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns the "from" string.
     *
     * @return The from string.
     */
    public String getFrom() {
        return from;
    }

    /**
     * Returns the "to" string.
     *
     * @return The to string.
     */
    public String getTo() {
        return to;
    }

    /**
     * Returns a string representation of an Event task.
     *
     * @return "[E]" + status + description + " (from: ... to: ...)"
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}
