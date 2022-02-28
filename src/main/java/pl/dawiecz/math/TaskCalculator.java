package pl.dawiecz.math;

import pl.dawiecz.math.task.Task;

import java.math.BigDecimal;

interface TaskCalculator {
    BigDecimal calculate(Task task);
}
