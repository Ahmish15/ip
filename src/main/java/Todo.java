/**
 * Represents a Todo task, which has only a description.
 */
public class Todo extends Task {
    /**
     * Constructs a Todo with the given description.
     *
     * @param description The task description.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns a string representation of a Todo task.
     *
     * @return "[T]" + status + description
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
