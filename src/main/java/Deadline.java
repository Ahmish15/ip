import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a Deadline task with a description and a "by" date/time.
 */
public class Deadline extends Task {
    private LocalDateTime by;

    /**
     * Constructs a Deadline with the given description and due date/time.
     *
     * @param description The task description.
     * @param by The deadline as a LocalDateTime.
     */
    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns the LocalDateTime representing the deadline.
     *
     * @return The by date/time.
     */
    public LocalDateTime getBy() {
        return by;
    }

    /**
     * Returns a string representation of a Deadline task,
     * including a formatted date/time.
     *
     * @return "[D]" + status + description + " (by: ...)"
     */
    @Override
    public String toString() {
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("d MMM yyyy, h:mm a");
        return "[D]" + super.toString() + " (by: " + by.format(outputFormat) + ")";
    }
}
