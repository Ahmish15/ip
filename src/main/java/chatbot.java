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
            } else if (input.startsWith("mark ")) {
                int index = Integer.parseInt(input.substring(5)) - 1;
                taskManager.mark(index);
            } else if (input.startsWith("unmark ")) {
                int index = Integer.parseInt(input.substring(7)) - 1;
                taskManager.unmark(index);
            } else {
                taskManager.addTask(input);
            }
        }
    }
}

