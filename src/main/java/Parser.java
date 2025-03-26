/**
 * Interprets user commands and lines from the storage file,
 * and performs the necessary actions on the TaskList.
 */
public class Parser {

    /**
     * Handles a single user command, updating tasks as necessary
     * and saving the changes.
     *
     * @param input    The raw command input.
     * @param tasks    The TaskList to operate on.
     * @param ui       The Ui for printing messages.
     * @param storage  The Storage for saving changes.
     * @return         True if the command is "bye" (indicating an exit), else false.
     * @throws TodoEmptyException        If a todo command has an empty description.
     * @throws DeadlineFormatException   If a deadline command is malformed.
     * @throws EventFormatException      If an event command is malformed.
     */
    public static boolean handleCommand(String input, TaskList tasks, Ui ui, Storage storage)
            throws TodoEmptyException, DeadlineFormatException, EventFormatException {
        if (input.equalsIgnoreCase("bye")) {
            return true;
        } else if (input.equalsIgnoreCase("list")) {
            tasks.listTasks();
        } else if (input.startsWith("mark ")) {
            int index = Integer.parseInt(input.substring(5).trim()) - 1;
            tasks.mark(index);
        } else if (input.startsWith("unmark ")) {
            int index = Integer.parseInt(input.substring(7).trim()) - 1;
            tasks.unmark(index);
        } else if (input.startsWith("delete ")) {
            int index = Integer.parseInt(input.substring(7).trim()) - 1;
            tasks.deleteTask(index);
        } else if (input.startsWith("todo")) {
            String description = input.substring(4).trim();
            if (description.isEmpty()) {
                throw new TodoEmptyException();
            }
            Todo todo = new Todo(description);
            tasks.addTask(todo);
        } else if (input.startsWith("deadline")) {
            if (!input.contains("/by")) {
                throw new DeadlineFormatException();
            }
            String[] parts = input.substring(8).split("/by");
            if (parts.length < 2) {
                throw new DeadlineFormatException();
            }
            String description = parts[0].trim();
            String by = parts[1].trim();
            if (description.isEmpty() || by.isEmpty()) {
                throw new DeadlineFormatException();
            }
            Deadline d = new Deadline(description, by);
            tasks.addTask(d);
        } else if (input.startsWith("event")) {
            if (!input.contains("/from") || !input.contains("/to")) {
                throw new EventFormatException();
            }
            String[] parts = input.substring(5).split("/from|/to");
            if (parts.length < 3) {
                throw new EventFormatException();
            }
            String description = parts[0].trim();
            String from = parts[1].trim();
            String to = parts[2].trim();
            if (description.isEmpty() || from.isEmpty() || to.isEmpty()) {
                throw new EventFormatException();
            }
            Event e = new Event(description, from, to);
            tasks.addTask(e);
        } else if (input.startsWith("find ")) {
            String keyword = input.substring(5).trim();
            tasks.find(keyword);
        } else {
            ui.showError("I'm sorry, I don't understand that command.");
        }
        storage.save(tasks);
        return false;
    }

    /**
     * Parses a single line from the storage file into a Task.
     * (Simple string-based approach for deadlines/events.)
     *
     * @param line A line from the file, e.g. "T | 0 | read book".
     * @return The corresponding Task object, or null if unrecognized.
     */
    public static Task parseTaskLine(String line) {
        String[] parts = line.split("\\|");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }
        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];

        switch (type) {
            case "T":
                Todo todo = new Todo(description);
                todo.setIsDone(isDone);
                return todo;
            case "D":
                String by = parts[3];
                Deadline d = new Deadline(description, by);
                d.setIsDone(isDone);
                return d;
            case "E":
                String from = parts[3];
                String to = parts[4];
                Event e = new Event(description, from, to);
                e.setIsDone(isDone);
                return e;
            default:
                return null;
        }
    }

    /**
     * Converts a Task into a line of text suitable for saving in the file.
     *
     * @param t The Task to encode.
     * @return  A string representation (e.g. "T | 1 | read book").
     */
    public static String encodeTask(Task t) {
        String doneBit = t.getIsDone() ? "1" : "0";
        if (t instanceof Todo) {
            return "T | " + doneBit + " | " + t.getDescription();
        } else if (t instanceof Deadline) {
            Deadline d = (Deadline) t;
            return "D | " + doneBit + " | " + d.getDescription() + " | " + d.getBy();
        } else if (t instanceof Event) {
            Event e = (Event) t;
            return "E | " + doneBit + " | " + e.getDescription() + " | " + e.getFrom() + " | " + e.getTo();
        } else {
            return "T | " + doneBit + " | " + t.getDescription();
        }
    }
}
