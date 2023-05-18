package ir.onlineshop.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller{

    @GetMapping("hello")
    fun hello() :String{
        return "hello world!"
    }
}