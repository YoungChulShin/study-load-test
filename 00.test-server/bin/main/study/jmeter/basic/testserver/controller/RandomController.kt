package study.jmeter.basic.testserver.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class RandomController {

    @PostMapping("/api/random/delay/max-500-millis")
    fun testMax500Millis(): String {
        val delay = Random.nextLong(50, 500)
        Thread.sleep(delay)
        val message = "OK - $delay - ${Thread.currentThread().name}"
        println(message)
        return message
    }

    @PostMapping("/api/random/delay/max-1000-millis")
    fun testMax1Seconds(): String {
        val delay = Random.nextLong(50, 1000)
        Thread.sleep(delay)
        val message = "OK - $delay - ${Thread.currentThread().name}"
        println(message)
        return message
    }
}