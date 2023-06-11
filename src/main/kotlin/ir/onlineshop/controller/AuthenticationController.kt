package ir.onlineshop.controller

import ir.onlineshop.common.dto.auth.AuthenticationResponse
import ir.onlineshop.common.dto.auth.SignInDto
import ir.onlineshop.common.dto.auth.SignUpDto
import ir.onlineshop.common.dto.mapper.BaseModelMapper
import ir.onlineshop.common.dto.user.UserReqDto
import ir.onlineshop.database.model.User
import ir.onlineshop.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("auth/")
class AuthenticationController @Autowired constructor(
    val userService: UserService
){

    val mapper= BaseModelMapper()

    @GetMapping("hello")
    fun hello(): String {
        return "hello world!"
    }

    @PostMapping("signUp")
    fun signUp(@RequestBody req: SignUpDto): ResponseEntity<AuthenticationResponse> {
        val user = mapper.toModel(req, User::class.java)
        val response = userService.signUp(user)
        return ResponseEntity(response, HttpStatus.CREATED)
    }

    @PostMapping("singIn")
    fun signIn(@RequestBody req: SignInDto): ResponseEntity<AuthenticationResponse> {
        val response = userService.signIn(req)
        return ResponseEntity(response, HttpStatus.CREATED)
    }
}