package ir.onlineshop.controller

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@EnableMethodSecurity
@RestController
class Controller {

    @GetMapping("hello")
    fun hello(): String {
        return "hello world!"
    }

    @GetMapping("hello/permitAll")
    fun helloPermitAll(): String {
        return "permitAll. hello world!"
    }
}