/**
 * Thrown when a user attempts to create an Event with incorrect formatting.
 */
public class EventFormatException extends Exception {
    /**
     * Constructs an EventFormatException and prints an error message.
     */
    public EventFormatException() {
        System.out.println("Event format should be: event <description> /from <start> /to <end>");
    }
}
