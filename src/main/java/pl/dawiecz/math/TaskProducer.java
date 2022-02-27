package pl.dawiecz.math;

import pl.dawiecz.math.task.TaskFactory;

public class TaskProducer {
    private final TaskFactory taskFactory;
    private final TaskQueue queue;

    public TaskProducer(TaskFactory taskFactory, TaskQueue queue) {
        this.taskFactory = taskFactory;
        this.queue = queue;
    }

    public void produce() {
        if ((double) queue.getSize() / queue.getMaxSize() <= 0.5) {
            while (queue.getSize() < queue.getMaxSize()){
                queue.put(taskFactory.create(20));
            }
        }
    }
}
