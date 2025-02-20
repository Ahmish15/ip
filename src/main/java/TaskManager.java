public class TaskManager {
    private Task[] tasks;
    private int taskCount;

    public TaskManager(){
        tasks = new Task[100];
        taskCount = 0;
    }

    public void addTask(Task t) {
        tasks[taskCount] = t;
        taskCount++;
        System.out.println("Got it. I've added this task:\n" + t.toString());
    }

    public void mark(int index) {
        tasks[index].setIsDone(true);
        System.out.println("Nice! I've marked this task as done:\n" + tasks[index].toString());
    }

    public void unmark(int index) {
        tasks[index].setIsDone(false);
        System.out.println("OK, I've marked this task as not done yet:\n" + tasks[index].toString());
    }

    public void listTask() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskCount; i++) {
            System.out.println((i + 1) + "." + tasks[i].toString());
        }
    }

    public void deleteTask(int index) {

        // Print the task that’s being deleted
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + tasks[index].toString());

        // Shift tasks left by one
        for (int i = index; i < taskCount - 1; i++) {
            tasks[i] = tasks[i + 1];
        }
        // Clear the last element and decrement count
        tasks[taskCount - 1] = null;
        taskCount--;

        System.out.println("Now you have " + taskCount + " tasks in the list.");
    }
}
