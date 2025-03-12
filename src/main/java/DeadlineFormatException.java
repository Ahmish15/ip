/**
 * Thrown when a user attempts to create a Deadline with incorrect formatting.
 */
public class DeadlineFormatException extends Exception {
    /**
     * Constructs a DeadlineFormatException and prints an error message.
     */
    public DeadlineFormatException() {
        System.out.println("Deadline format should be: deadline <description> /by <time>");
    }
}
