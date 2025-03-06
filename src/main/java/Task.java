public class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(boolean b) {
        isDone = b;
    }

    public String status() {
        return isDone ? "[X]" : "[ ]";
    }

    @Override
    public String toString() {
        return status() + " " + description;
    }
}
