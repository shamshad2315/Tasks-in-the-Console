import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskList {
    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;   // simple counter for unique ids

    public Task addTask(String title, String priority) {
        Task task = new Task(nextId++, title, priority);
        tasks.add(task);
        return task;
    }

    // Returns: 0 = completed now, 1 = id not found, 2 = already completed
    public int completeTask(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                if (t.isCompleted()) {
                    return 2;
                }
                t.markCompleted();
                return 0;
            }
        }
        return 1;
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet. Add one first!");
            return;
        }
        // false sorts before true, so incomplete tasks come first
        List<Task> sorted = new ArrayList<>(tasks);
        sorted.sort(Comparator.comparing(Task::isCompleted));
        System.out.println("\n--- Your Tasks ---");
        for (Task t : sorted) {
            System.out.println(t);
        }
    }
}