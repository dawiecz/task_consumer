package pl.dawiecz.math

import pl.dawiecz.math.task.Task
import pl.dawiecz.math.task.TaskFactory
import spock.lang.Specification
import spock.lang.Subject

class TaskProducerSpec extends Specification {
    def MAX_SIZE = 5
    def taskFactory = new TaskFactory()
    def taskQueue = new TaskQueue(MAX_SIZE)

    @Subject
    def taskProducer = new TaskProducer(taskFactory, taskQueue)

    def "should produce tasks"() {
        when:
            taskProducer.produce()
        then:
            taskQueue.size == 5
            with(taskQueue.poll()) {
                isPresent()
                get().operation != null
            }
    }

    def "should not add tasks when is still more than half tasks"() {
        given:
            for (i in 0..<3) {
                taskQueue.put(Mock(Task))
            }
        when:
            taskProducer.produce()
        then:
            taskQueue.size == 3
    }
}
