package pl.dawiecz.math;

import pl.dawiecz.math.task.Task;

import java.util.Optional;
import java.util.concurrent.LinkedBlockingQueue;

import static java.util.Optional.ofNullable;

public class TaskQueue {
    private final LinkedBlockingQueue<Task> tasks;
    private final int maxSize;

    public TaskQueue(int maxSize) {
        this.tasks = new LinkedBlockingQueue<>(maxSize);
        this.maxSize = maxSize;
    }

    public Optional<Task> poll(){
        return ofNullable(tasks.poll());
    }

    public boolean put(Task task){
        try{
            tasks.add(task);
            return true;
        } catch (IllegalStateException e){
            return false;
        }
    }

    public int getSize(){
        return tasks.size();
    }

    public int getMaxSize() {
        return maxSize;
    }
}