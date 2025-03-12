/**
 * Manages an array of Task objects and provides operations
 * such as add, delete, mark, unmark, list, and find.
 */
public class TaskList {
    private Task[] tasks;
    private int size;

    /**
     * Constructs an empty TaskList with capacity 100.
     */
    public TaskList() {
        tasks = new Task[100];
        size = 0;
    }

    /**
     * Adds a task when loading from file (no console output).
     *
     * @param t The task to add.
     */
    public void addFromLoad(Task t) {
        tasks[size] = t;
        size++;
    }

    /**
     * Adds a new task and prints a confirmation message.
     *
     * @param t The task to add.
     */
    public void addTask(Task t) {
        tasks[size] = t;
        size++;
        System.out.println("Got it. I've added this task:\n  " + t);
    }

    /**
     * Marks a task as done.
     *
     * @param index The zero-based index of the task to mark.
     */
    public void mark(int index) {
        if (index < 0 || index >= size) {
            System.out.println("No task at that index to mark!");
            return;
        }
        tasks[index].setIsDone(true);
        System.out.println("Nice! I've marked this task as done:\n  " + tasks[index]);
    }

    /**
     * Unmarks a task as not done.
     *
     * @param index The zero-based index of the task to unmark.
     */
    public void unmark(int index) {
        if (index < 0 || index >= size) {
            System.out.println("No task at that index to unmark!");
            return;
        }
        tasks[index].setIsDone(false);
        System.out.println("OK, I've marked this task as not done yet:\n  " + tasks[index]);
    }

    /**
     * Deletes a task from the list, shifting subsequent tasks left.
     *
     * @param index The zero-based index of the task to delete.
     */
    public void deleteTask(int index) {
        if (index < 0 || index >= size) {
            System.out.println("No task at index " + (index + 1));
            return;
        }
        System.out.println("Noted. I've removed this task:\n  " + tasks[index]);
        for (int i = index; i < size - 1; i++) {
            tasks[i] = tasks[i + 1];
        }
        tasks[size - 1] = null;
        size--;
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    /**
     * Lists all tasks with their 1-based indices.
     */
    public void listTasks() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + "." + tasks[i]);
        }
    }

    /**
     * Finds tasks whose descriptions contain the given keyword.
     *
     * @param keyword The string to search for.
     */
    public void find(String keyword) {
        System.out.println("Here are the matching tasks in your list:");
        int index = 1;
        for (int i = 0; i < size; i++) {
            if (tasks[i].getDescription().contains(keyword)) {
                System.out.println(index + "." + tasks[i]);
                index++;
            }
        }
        if (index == 1) {
            System.out.println("No matching tasks found.");
        }
    }

    /**
     * Returns the task at the specified index.
     *
     * @param i The zero-based index.
     * @return The Task at index i.
     */
    public Task get(int i) {
        return tasks[i];
    }

    /**
     * Returns the current number of tasks in the list.
     *
     * @return The size of the TaskList.
     */
    public int size() {
        return size;
    }
}
