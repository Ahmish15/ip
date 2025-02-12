public class TodoEmptyException extends Exception {
    public TodoEmptyException() {
        System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
    }
}
