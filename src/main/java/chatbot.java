public class chatbot {
    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    public chatbot(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = storage.load();
    }

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
            } catch (NumberFormatException e) {
                ui.showError("Please enter a valid task number!");
            } catch (Exception e) {
                ui.showError(e.getMessage());
            }
        }
        ui.showGoodbye();
    }

    public static void main(String[] args) {
        new chatbot("data/duke.txt").run();
    }
}
