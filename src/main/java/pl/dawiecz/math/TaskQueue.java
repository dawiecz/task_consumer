package pl.dawiecz.math;

import pl.dawiecz.math.task.Task;

import java.util.Optional;
import java.util.concurrent.LinkedBlockingQueue;

import static java.util.Optional.ofNullable;

class TaskQueue {
    private final LinkedBlockingQueue<Task> tasks;
    private final int maxSize;

    TaskQueue(int maxSize) {
        this.tasks = new LinkedBlockingQueue<>(maxSize);
        this.maxSize = maxSize;
    }

    Optional<Task> poll(){
        return ofNullable(tasks.poll());
    }

    boolean put(Task task){
        try{
            tasks.add(task);
            return true;
        } catch (IllegalStateException e){
            return false;
        }
    }

    int getSize(){
        return tasks.size();
    }

    int getMaxSize() {
        return maxSize;
    }
}