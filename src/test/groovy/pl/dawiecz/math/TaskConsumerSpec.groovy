package pl.dawiecz.math


import pl.dawiecz.math.task.TaskFactory
import spock.lang.Specification
import spock.lang.Subject

class TaskConsumerSpec extends Specification {
    def MAX_SIZE = 5
    def taskQueue = new TaskQueue(MAX_SIZE)
    def taskFactory = new TaskFactory()
    def taskCalculator = new EvalexTaskCalculator()

    @Subject
    TaskConsumer taskConsumer = new TaskConsumer(taskQueue, taskCalculator)

    def "should consume task"(){
        given:
            taskQueue.put(taskFactory.create(20))
        when:
            taskConsumer.consume()
        then:
            taskQueue.size == 0
    }
}
