public class DeadlineFormatException extends Exception {
    public DeadlineFormatException() {
        System.out.println("Deadline format should be: deadline <description> /by <time>");
    }
}
