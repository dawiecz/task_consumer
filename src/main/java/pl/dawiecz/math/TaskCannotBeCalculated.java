package pl.dawiecz.math;

import pl.dawiecz.math.task.Task;

class TaskCannotBeCalculated extends RuntimeException {
    TaskCannotBeCalculated(Task task) {
        super("Task cannot be calculated: " + task.getOperation());
    }
}
