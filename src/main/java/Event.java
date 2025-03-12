import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an Event task with a description, a "from" date/time, and a "to" date/time.
 */
public class Event extends Task {
    private LocalDateTime from;
    private LocalDateTime to;

    /**
     * Constructs an Event with the given description, from-date/time, and to-date/time.
     *
     * @param description The task description.
     * @param from The start time/place as a LocalDateTime.
     * @param to The end time/place as a LocalDateTime.
     */
    public Event(String description, LocalDateTime from, LocalDateTime to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns the start date/time of the event.
     *
     * @return The from date/time.
     */
    public LocalDateTime getFrom() {
        return from;
    }

    /**
     * Returns the end date/time of the event.
     *
     * @return The to date/time.
     */
    public LocalDateTime getTo() {
        return to;
    }

    /**
     * Returns a string representation of an Event task,
     * including formatted start and end date/time.
     *
     * @return "[E]" + status + description + " (from: ... to: ...)"
     */
    @Override
    public String toString() {
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("d MMM yyyy, h:mm a");
        return "[E]" + super.toString()
                + " (from: " + from.format(outputFormat)
                + " to: " + to.format(outputFormat) + ")";
    }
}
