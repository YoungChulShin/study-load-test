package study.jmeter.basic.testserver.controller

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {

    @PostMapping("/api/greeting/hello/{name}")
    fun greeting(
        @PathVariable name: String
    ): String {
        val message = "Hello, $name!"
        println(message)
        return message
    }
}