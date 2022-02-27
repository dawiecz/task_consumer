package pl.dawiecz.math

import com.udojava.evalex.Expression
import pl.dawiecz.math.task.Task
import spock.lang.Specification
import spock.lang.Subject

class EvalexTaskCalculatorSpec extends Specification {
    @Subject
    EvalexTaskCalculator stringCalculator = new EvalexTaskCalculator()

    def "should calculate operation"() {
        expect:
            stringCalculator.calculate(new Task(value)) == result
        where:
            value   || result
            "3-2*3" || -3.0
            "5+6"   || 11
    }

    def "should throw exception when operation is incorrect"() {
        when:
            stringCalculator.calculate(new Task(value))
        then:
            thrown(exception)
        where:
            value  || exception
            "/3-2" || Expression.ExpressionException
            "*5+5" || Expression.ExpressionException
            "5/"   || Expression.ExpressionException
            "9/0"  || ArithmeticException
    }
}
