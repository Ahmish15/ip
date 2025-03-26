/**
 * Represents a Deadline task with a description and a "by" string.
 */
public class Deadline extends Task {
    private String by;

    /**
     * Constructs a Deadline with the given description and by-string.
     *
     * @param description The task description.
     * @param by The deadline or due date/time as a string.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns the string specifying the deadline.
     *
     * @return The by string.
     */
    public String getBy() {
        return by;
    }

    /**
     * Returns a string representation of a Deadline task.
     *
     * @return "[D]" + status + description + " (by: ...)"
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
