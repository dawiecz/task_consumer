package pl.dawiecz.math;

import pl.dawiecz.math.task.Task;

import java.math.BigDecimal;

public interface TaskCalculator {
    BigDecimal calculate(Task task);
}
