package pl.dawiecz.math

import com.udojava.evalex.Expression
import pl.dawiecz.math.task.Task
import spock.lang.Specification
import spock.lang.Subject

class EvalexTaskCalculatorSpec extends Specification {
    @Subject
    def taskCalculator = new EvalexTaskCalculator()

    def "should calculate operation"() {
        expect:
            taskCalculator.calculate(new Task(value)) == result
        where:
            value   || result
            "3-2*3" || -3.0
            "5+6"   || 11
    }

    def "should throw exception when operation is incorrect"() {
        when:
            taskCalculator.calculate(new Task(value))
        then:
            thrown(exception)
        where:
            value  || exception
            "/3-2" || TaskCannotBeCalculated
            "*5+5" || TaskCannotBeCalculated
            "5/"   || TaskCannotBeCalculated
            "9/0"  || TaskCannotBeCalculated
    }
}
