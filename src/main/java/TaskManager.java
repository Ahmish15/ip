import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class TaskManager {
    private Task[] tasks;
    private int taskCount;

    private static final String FILE_PATH = "data/duke.txt";

    public TaskManager(){
        tasks = new Task[100];
        taskCount = 0;
        loadFromFile();
    }

    private void loadFromFile() {
        try {
            File f = new File(FILE_PATH);
            f.getParentFile().mkdirs();

            if (!f.exists()) {
                f.createNewFile();
                return;
            }

            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) {
                    continue;
                }
                parseTaskFromLine(line);
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private void parseTaskFromLine(String line) {

        String[] parts = line.split("\\|");
        // Strip whitespace from each part
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }

        String type = parts[0];           // T/D/E
        boolean isDone = parts[1].equals("1");
        String description = parts[2];

        Task t;
        switch (type) {
            case "T":
                t = new Todo(description);
                break;
            case "D":
                String by = parts[3];
                t = new Deadline(description, by);
                break;
            case "E":
                String dateOrTime = parts[3];
                t = new Event(description, dateOrTime, "");
                break;
            default:
                return;
        }

        t.setIsDone(isDone);
        tasks[taskCount] = t;
        taskCount++;
    }

    private void saveToFile() {
        try {
            File f = new File(FILE_PATH);
            f.getParentFile().mkdirs();
            FileWriter fw = new FileWriter(f);

            for (int i = 0; i < taskCount; i++) {
                Task t = tasks[i];
                fw.write(encodeTaskAsLine(t) + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    private String encodeTaskAsLine(Task t) {
        String doneBit = t.getIsDone() ? "1" : "0";
        if (t instanceof Todo) {
            return "T | " + doneBit + " | " + t.getDescription();
        } else if (t instanceof Deadline) {
            Deadline d = (Deadline) t;
            return "D | " + doneBit + " | " + d.getDescription() + " | " + d.getBy();
        } else if (t instanceof Event) {
            Event e = (Event) t;
            return "E | " + doneBit + " | " + e.getDescription() + " | " + e.getFrom() + " - " + e.getTo();
        } else {
            return "T | " + doneBit + " | " + t.getDescription();
        }
    }


    public void addTask(Task t) {
        tasks[taskCount] = t;
        taskCount++;
        System.out.println("Got it. I've added this task:\n" + t.toString());
        saveToFile();
    }

    public void mark(int index) {
        tasks[index].setIsDone(true);
        System.out.println("Nice! I've marked this task as done:\n" + tasks[index].toString());
        saveToFile();
    }

    public void unmark(int index) {
        tasks[index].setIsDone(false);
        System.out.println("OK, I've marked this task as not done yet:\n" + tasks[index].toString());
        saveToFile();
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
        saveToFile();
    }
}
