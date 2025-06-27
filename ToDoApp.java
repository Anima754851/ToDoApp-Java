import java.util.*;

public class ToDoApp {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Task> tasks = new ArrayList<>();
    static int taskId = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n📋 Welcome to To-Do List App");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskAsCompleted();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("👋 Exiting... Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("⚠ Invalid choice.");
            }
        }
    }

    public static void addTask() {
        System.out.print("Enter task title: ");
        String title = sc.nextLine();
        Task t = new Task(taskId++, title);
        tasks.add(t);
        System.out.println("✅ Task added successfully!");
    }

    public static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("📭 No tasks found.");
        } else {
            System.out.println("📄 Your Tasks:");
            for (Task t : tasks) {
                System.out.println(t);
            }
        }
    }

    public static void markTaskAsCompleted() {
        System.out.print("Enter task ID to mark as completed: ");
        int id = sc.nextInt();
        boolean found = false;
        for (Task t : tasks) {
            if (t.id == id) {
                t.isCompleted = true;
                System.out.println("✅ Task marked as completed!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("❌ Task ID not found.");
        }
    }

    public static void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        int id = sc.nextInt();
        Iterator<Task> itr = tasks.iterator();
        boolean found = false;
        while (itr.hasNext()) {
            Task t = itr.next();
            if (t.id == id) {
                itr.remove();
                System.out.println("🗑️ Task deleted successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("❌ Task ID not found.");
        }
    }
}
