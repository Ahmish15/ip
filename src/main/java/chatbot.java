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
            } else if (input.equalsIgnoreCase("list")) {
                taskManager.listTask();
            }else if (input.startsWith("mark ")) {
                int index = Integer.parseInt(input.substring(5)) - 1;
                taskManager.mark(index);
            } else if (input.startsWith("unmark ")) {
                int index = Integer.parseInt(input.substring(7)) - 1;
                taskManager.unmark(index);
            } else if(input.startsWith("todo")) {
                Todo todo = new Todo(input.substring(5));
                taskManager.addTask(todo);
            } else if(input.startsWith("deadline")) {
                String[] parts = input.substring(9).split("/by");
                String description = parts[0].trim();
                String by = parts[1].trim();
                Deadline deadline = new Deadline(description, by);
                taskManager.addTask(deadline);
            } else if(input.startsWith("event")) {
                String[] parts = input.substring(6).split("/from|/to");
                String description = parts[0].trim();
                String from = parts[1].trim();
                String to = parts[2].trim();
                Event event = new Event(description, from, to);
                taskManager.addTask(event);
            } else if (input.startsWith("list")) {
                taskManager.listTask();
            }
        }
        }

    }

