import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Manages loading and saving of tasks to a file.
 */
public class Storage {
    private String filePath;

    /**
     * Constructs a Storage object with the specified file path.
     *
     * @param filePath The path to the storage file.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads tasks from the file into a new TaskList.
     *
     * @return A TaskList containing tasks loaded from the file.
     */
    public TaskList load() {
        TaskList tasks = new TaskList();
        try {
            File f = new File(filePath);
            f.getParentFile().mkdirs();
            if (!f.exists()) {
                f.createNewFile();
                return tasks;
            }
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.trim().isEmpty()) {
                    Task t = Parser.parseTaskLine(line);
                    if (t != null) {
                        tasks.addFromLoad(t);
                    }
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return tasks;
    }

    /**
     * Saves all tasks from the given TaskList to the file.
     *
     * @param tasks The TaskList whose tasks are to be saved.
     */
    public void save(TaskList tasks) {
        try {
            File f = new File(filePath);
            f.getParentFile().mkdirs();
            FileWriter fw = new FileWriter(f);
            for (int i = 0; i < tasks.size(); i++) {
                Task t = tasks.get(i);
                fw.write(Parser.encodeTask(t) + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
