package pl.dawiecz.math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class TaskConsumer {
    private static final Logger logger = LoggerFactory.getLogger(TaskConsumer.class);
    private final TaskQueue queue;
    private final TaskCalculator taskCalculator;

    TaskConsumer(TaskQueue queue, TaskCalculator taskCalculator) {
        this.queue = queue;
        this.taskCalculator = taskCalculator;
    }

    void consume() {
        try {
            queue.poll().ifPresent(task -> logger.info("Task: {} Result: {}", task, taskCalculator.calculate(task)));
        } catch (Exception e) {
            logger.warn("Exception during processing task: {}", e.getMessage());
        }
    }
}
