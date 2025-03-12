/**
 * The main entry point for the chatbot application.
 * Manages the Ui, Storage, and TaskList components.
 */
public class chatbot {
    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    /**
     * Creates a chatbot instance with the specified data file path.
     *
     * @param filePath The path to the storage file.
     */
    public chatbot(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = storage.load();
    }

    /**
     * Runs the main chatbot loop until the user exits.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            String input = ui.readCommand();
            try {
                isExit = Parser.handleCommand(input, tasks, ui, storage);
            } catch (TodoEmptyException
                     | DeadlineFormatException
                     | EventFormatException e) {
                // Custom exceptions already print their messages in constructors
            } catch (NumberFormatException e) {
                ui.showError("Please enter a valid task number!");
            } catch (Exception e) {
                ui.showError(e.getMessage());
            }
        }
        ui.showGoodbye();
    }

    /**
     * The main method. Creates a new chatbot instance and runs it.
     *
     * @param args Command-line arguments (unused).
     */
    public static void main(String[] args) {
        new chatbot("data/duke.txt").run();
    }
}
