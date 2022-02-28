package pl.dawiecz.math;

import com.udojava.evalex.Expression;
import pl.dawiecz.math.task.Task;

import java.math.BigDecimal;

class EvalexTaskCalculator implements TaskCalculator {
    public BigDecimal calculate(Task task) {
        Expression expression = new Expression(task.getOperation());
        try {
           return expression.eval();
        } catch (Expression.ExpressionException | ArithmeticException e) {
            throw new TaskCannotBeCalculated(task);
        }
    }
}