import java.util.Scanner;

public class chatbot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        System.out.print("Hello! I'm juan\n" + "What can I do for you?\n");


        while (true) {
            String input = in.nextLine();
            if (input.equalsIgnoreCase("bye")) {
                System.out.print("Bye. Hope to see you again soon!");
                break;
            }

            try {
                if (input.equalsIgnoreCase("list")) {
                    taskManager.listTask();
                }else if (input.startsWith("mark ")) {
                    int index = Integer.parseInt(input.substring(5)) - 1;
                    taskManager.mark(index);
                } else if (input.startsWith("unmark ")) {
                    int index = Integer.parseInt(input.substring(7)) - 1;
                    taskManager.unmark(index);
                } else if(input.startsWith("todo")) {
                    String description = input.substring(4).trim();
                    if (description.isEmpty()) {
                        throw new TodoEmptyException();
                    }
                    Todo todo = new Todo(description);
                    taskManager.addTask(todo);
                } else if(input.startsWith("deadline")) {
                    if (!input.contains("/by")) {
                        throw new DeadlineFormatException();
                    }
                    String[] parts = input.substring(9).split("/by");
                    if (parts.length < 2) {
                        throw new DeadlineFormatException();
                    }
                    String description = parts[0].trim();
                    String by = parts[1].trim();
                    if (description.isEmpty() || by.isEmpty()) {
                        throw new DeadlineFormatException();
                    }
                    Deadline deadline = new Deadline(description, by);
                    taskManager.addTask(deadline);
                } else if(input.startsWith("event")) {
                    if (!input.contains("/from") || !input.contains("/to")) {
                        throw new EventFormatException();
                    }
                    String[] parts = input.substring(6).split("/from|/to");
                    if (parts.length < 3) {
                        throw new EventFormatException();
                    }
                    String description = parts[0].trim();
                    String from = parts[1].trim();
                    String to = parts[2].trim();
                    if (description.isEmpty() || from.isEmpty() || to.isEmpty()) {
                        throw new EventFormatException();
                    }
                    Event event = new Event(description, from, to);
                    taskManager.addTask(event);
                } else if (input.startsWith("list")) {
                    taskManager.listTask();
                } else if (input.startsWith("delete")) {
                    int index = Integer.parseInt(input.substring(7)) - 1;
                    taskManager.deleteTask(index);
                }
            } catch (TodoEmptyException e) {

            } catch (DeadlineFormatException e) {

            } catch (EventFormatException e) {

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid task number!");
            }
        }
    }
}

