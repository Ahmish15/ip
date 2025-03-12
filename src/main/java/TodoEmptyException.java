/**
 * Thrown when a user attempts to create a Todo with an empty description.
 */
public class TodoEmptyException extends Exception {
    /**
     * Constructs a TodoEmptyException and prints an error message.
     */
    public TodoEmptyException() {
        System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
    }
}
