public class Task {
    private final int id;
    private final String title;
    private final String priority;   // HIGH, MEDIUM or LOW
    private boolean completed;

    public Task(int id, String title, String priority) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.completed = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getPriority() { return priority; }
    public boolean isCompleted() { return completed; }
    public void markCompleted() { this.completed = true; }

    @Override
    public String toString() {
        String status = completed ? "[DONE]" : "[    ]";
        return status + " #" + id + " " + title + " (Priority: " + priority + ")";
    }
}