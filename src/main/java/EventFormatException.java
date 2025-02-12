public class EventFormatException extends Exception {
    public EventFormatException() {
        System.out.println("Event format should be: event <description> /from <start> /to <end>");
    }
}
