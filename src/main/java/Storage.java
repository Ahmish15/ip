import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

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
