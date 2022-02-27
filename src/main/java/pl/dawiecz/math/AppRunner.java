package pl.dawiecz.math;

import pl.dawiecz.math.task.TaskFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppRunner {

    public static void main(String... args) {
        TaskQueue taskQueue = new TaskQueue(100);
        TaskCalculator taskCalculator = new EvalexTaskCalculator();
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 2; i++) {
            executorService.submit(() -> {
                TaskConsumer taskConsumer = new TaskConsumer(taskQueue, taskCalculator);
                while (true) {
                    taskConsumer.consume();
                }
            });
        }

        TaskFactory taskFactory = new TaskFactory();
        for (int i = 0; i < 4; i++) {
            executorService.submit(() -> {
                TaskProducer taskProducer = new TaskProducer(taskFactory, taskQueue);
                while (true) {
                    taskProducer.produce();
                }
            });
        }
    }
}
