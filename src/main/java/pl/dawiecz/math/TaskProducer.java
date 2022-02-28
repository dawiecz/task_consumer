package pl.dawiecz.math;

import pl.dawiecz.math.task.TaskFactory;

class TaskProducer {
    private final TaskFactory taskFactory;
    private final TaskQueue queue;

    TaskProducer(TaskFactory taskFactory, TaskQueue queue) {
        this.taskFactory = taskFactory;
        this.queue = queue;
    }

    void produce() {
        if ((double) queue.getSize() / queue.getMaxSize() <= 0.5) {
            while (queue.getSize() < queue.getMaxSize()){
                queue.put(taskFactory.create(20));
            }
        }
    }
}
