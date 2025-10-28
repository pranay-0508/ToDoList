import java.util.Scanner;

public class ToDoListApp{
    private static String[] tasks = new String[0]; // start with empty array
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- To-Do List ---");
            printTasks();
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    deleteTask();
                    break;
                case "3":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void printTasks() {
        if (tasks.length == 0) {
            System.out.println("(No tasks)");
        } else {
            for (int i = 0; i < tasks.length; i++) {
                System.out.println((i + 1) + ". " + tasks[i]);
            }
        }
    }

    private static void addTask() {
        while (true) {
            System.out.print("Enter new task (or type 'done' to stop): ");
            String task = scanner.nextLine().trim();

            if (task.equalsIgnoreCase("done")) {
                break; // stop adding when user types 'done'
            }

            if (!task.isEmpty()) {
                // Create a new array with one more slot
                String[] newTasks = new String[tasks.length + 1];

                // Copy old tasks to new array
                for (int i = 0; i < tasks.length; i++) {
                    newTasks[i] = tasks[i];
                }

                // Add the new task at the end
                newTasks[newTasks.length - 1] = task;

                // Replace old array
                tasks = newTasks;

                System.out.println("Task added.");
            } else {
                System.out.println("Please enter a valid task.");
            }
        }
    }

    private static void deleteTask() {
        if (tasks.length == 0) {
            System.out.println("No tasks to delete.");
            return;
        }

        System.out.print("Enter task number to delete: ");
        try {
            int num = Integer.parseInt(scanner.nextLine());
            if (num >= 1 && num <= tasks.length) {
                // Create a new array with one less slot
                String[] newTasks = new String[tasks.length - 1];
                int index = 0;
                for (int i = 0; i < tasks.length; i++) {
                    if (i != num - 1) {
                        newTasks[index++] = tasks[i];
                    }
                }
                tasks = newTasks;
                System.out.println("Task deleted.");
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number.");
        }
    }
}