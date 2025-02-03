public class TaskManager {
    private Task[] tasks;
    private static boolean[] isDone;
    private int taskCount;


    public TaskManager(){
        tasks = new Task[100];
        isDone = new boolean[100];
        taskCount = 0;
    }

    public void addTask(String input){
        tasks[taskCount] = new Task(input);
        isDone[taskCount] = false;
        System.out.println("added: " + input);
        taskCount++;
    }

    public String status(int index){
        return isDone[index] ? "[X]" : "[ ]";
    }

    public void mark(int index) {
        isDone[index] = true;
        System.out.println("Nice! I've marked this task as done:\n" + status(index) + " " + tasks[index].getDescription());
    }

    public void unmark(int index) {
        isDone[index] = false;
        System.out.println("OK, I've marked this task as not done yet:\n" + status(index) + " " + tasks[index].getDescription());
    }

    public void listTask() {
        for (int i = 0; i < taskCount; i++) {
            System.out.println((i + 1) + ". " + status(i) + " " + tasks[i].getDescription());
        }
    }

}
