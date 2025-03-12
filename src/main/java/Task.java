/**
 * Represents a generic Task with a description and completion status.
 */
public class Task {
    private String description;
    private boolean isDone;

    /**
     * Constructs a Task with the given description.
     *
     * @param description The task's description.
     */
    public Task(String description) {
        this.description = description;
    }

    /**
     * Returns the description of the task.
     *
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns true if the task is done, false otherwise.
     *
     * @return The isDone status.
     */
    public boolean getIsDone() {
        return isDone;
    }

    /**
     * Sets whether the task is done.
     *
     * @param b True if done, false otherwise.
     */
    public void setIsDone(boolean b) {
        isDone = b;
    }

    /**
     * Returns "[X]" if done, "[ ]" otherwise.
     *
     * @return A string representing the done status.
     */
    public String status() {
        return isDone ? "[X]" : "[ ]";
    }

    /**
     * Returns a string representation: "[X]" or "[ ]" plus the description.
     *
     * @return The string form of this task.
     */
    @Override
    public String toString() {
        return status() + " " + description;
    }
}
