public class TaskList {
    private Task[] tasks;
    private int size;

    public TaskList() {
        tasks = new Task[100];
        size = 0;
    }

    public void addFromLoad(Task t) {
        tasks[size] = t;
        size++;
    }

    public void addTask(Task t) {
        tasks[size] = t;
        size++;
        System.out.println("Got it. I've added this task:\n  " + t);
    }

    public void mark(int index) {
        if (index < 0 || index >= size) {
            System.out.println("No task at that index to mark!");
            return;
        }
        tasks[index].setIsDone(true);
        System.out.println("Nice! I've marked this task as done:\n  " + tasks[index]);
    }

    public void unmark(int index) {
        if (index < 0 || index >= size) {
            System.out.println("No task at that index to unmark!");
            return;
        }
        tasks[index].setIsDone(false);
        System.out.println("OK, I've marked this task as not done yet:\n  " + tasks[index]);
    }

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

    public void listTasks() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + "." + tasks[i]);
        }
    }

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

    public Task get(int i) {
        return tasks[i];
    }

    public int size() {
        return size;
    }
}
