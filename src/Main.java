import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== TaskForge =====");
            System.out.println("1) Add task");
            System.out.println("2) List tasks");
            System.out.println("3) Complete task");
            System.out.println("4) Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Title: ");
                    String title = scanner.nextLine().trim();
                    if (title.isEmpty()) {
                        System.out.println("Error: title cannot be empty.");
                        break;
                    }
                    System.out.print("Priority (HIGH/MEDIUM/LOW): ");
                    String priority = scanner.nextLine().trim().toUpperCase();
                    if (!priority.equals("HIGH") && !priority.equals("MEDIUM") && !priority.equals("LOW")) {
                        System.out.println("Invalid priority, using MEDIUM.");
                        priority = "MEDIUM";
                    }
                    Task t = taskList.addTask(title, priority);
                    System.out.println("Task added with id " + t.getId() + ".");
                    break;

                case "2":
                    taskList.listTasks();
                    break;
                case "3":
                    taskList.listTasks();
                    System.out.print("Enter the task NUMBER (the digit after #) to complete: ");
                    try {
                        int id = Integer.parseInt(scanner.nextLine().trim());
                        int result = taskList.completeTask(id);
                        if (result == 0) {
                            System.out.println("Task " + id + " marked as done. ✔");
                        } else if (result == 1) {
                            System.out.println("Error: no task found with id " + id + ".");
                        } else {
                            System.out.println("Task " + id + " is already completed.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: '" + "that" + "' is not a number. Type the id, for example: 1");
                    }
                    break;

                case "4":
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please choose 1-4.");
            }
        }
        scanner.close();
    }
}