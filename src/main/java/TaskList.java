import java.util.ArrayList;

/**
 * Manages a list of Task objects and provides operations
 * such as add, delete, mark, unmark, list, and find.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructs an empty TaskList using an ArrayList.
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Adds a task when loading from file (no console output).
     *
     * @param t The task to add.
     */
    public void addFromLoad(Task t) {
        tasks.add(t);
    }

    /**
     * Adds a new task and prints a confirmation message.
     *
     * @param t The task to add.
     */
    public void addTask(Task t) {
        tasks.add(t);
        System.out.println("Got it. I've added this task:\n  " + t);
    }

    /**
     * Marks a task as done.
     *
     * @param index The zero-based index of the task to mark.
     */
    public void mark(int index) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("No task at that index to mark!");
            return;
        }
        tasks.get(index).setIsDone(true);
        System.out.println("Nice! I've marked this task as done:\n  " + tasks.get(index));
    }

    /**
     * Unmarks a task as not done.
     *
     * @param index The zero-based index of the task to unmark.
     */
    public void unmark(int index) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("No task at that index to unmark!");
            return;
        }
        tasks.get(index).setIsDone(false);
        System.out.println("OK, I've marked this task as not done yet:\n  " + tasks.get(index));
    }

    /**
     * Deletes a task from the list, printing a confirmation.
     *
     * @param index The zero-based index of the task to delete.
     */
    public void deleteTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("No task at index " + (index + 1));
            return;
        }
        System.out.println("Noted. I've removed this task:\n  " + tasks.get(index));
        tasks.remove(index);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    /**
     * Lists all tasks with their 1-based indices.
     */
    public void listTasks() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + "." + tasks.get(i));
        }
    }

    /**
     * Finds tasks whose descriptions contain the given keyword.
     *
     * @param keyword The string to search for.
     */
    public void find(String keyword) {
        System.out.println("Here are the matching tasks in your list:");
        int foundCount = 0;
        for (Task t : tasks) {
            if (t.getDescription().contains(keyword)) {
                foundCount++;
                System.out.println(foundCount + "." + t);
            }
        }
        if (foundCount == 0) {
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
        return tasks.get(i);
    }

    /**
     * Returns the current number of tasks in the list.
     *
     * @return The size of the TaskList.
     */
    public int size() {
        return tasks.size();
    }
}
