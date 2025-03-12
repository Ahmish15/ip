import java.util.Scanner;

/**
 * Handles input and output interactions with the user.
 */
public class Ui {
    private Scanner sc;

    /**
     * Constructs a Ui object with a Scanner for reading user input.
     */
    public Ui() {
        sc = new Scanner(System.in);
    }

    /**
     * Prints the welcome message to the user.
     */
    public void showWelcome() {
        System.out.println("Hello! I'm juan\nWhat can I do for you?");
    }

    /**
     * Prints the goodbye message to the user.
     */
    public void showGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Reads a command from the user.
     *
     * @return The command string entered by the user.
     */
    public String readCommand() {
        return sc.nextLine();
    }

    /**
     * Prints an error message.
     *
     * @param message The error message to display.
     */
    public void showError(String message) {
        System.out.println(message);
    }
}
