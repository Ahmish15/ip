public class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(boolean IsDone) {
        this.isDone = IsDone;
    }

    public String status(){
        return isDone ? "[X]" : "[ ]";
    }

    public String toString(){
        return status() + " " + getDescription();
    }
}





