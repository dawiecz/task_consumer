package pl.dawiecz.math.task;

public class Task {
    private final String operation;

    Task(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return "Task{" +
                "operation='" + operation + '\'' +
                '}';
    }
}
