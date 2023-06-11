package ir.onlineshop.controller

import ir.onlineshop.common.dto.auth.SignInDto
import ir.onlineshop.common.dto.auth.SignUpDto
import ir.onlineshop.common.dto.mapper.BaseModelMapper
import ir.onlineshop.common.dto.user.UserReqDto
import ir.onlineshop.database.model.User
import ir.onlineshop.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("auth/")
class AuthenticationController @Autowired constructor(
    val userService: UserService
){

    val mapper= BaseModelMapper()

    @PostMapping("signUp")
    fun signUp(@RequestBody req: SignUpDto): ResponseEntity<String> {
        val user = mapper.toModel(req, User::class.java)
        userService.signUp(user)
        return ResponseEntity("ok", HttpStatus.CREATED)
    }

    @PostMapping("singIn")
    fun signIn(@RequestBody req: SignInDto): ResponseEntity<String> {
        userService.signIn(req)
        return ResponseEntity("ok", HttpStatus.CREATED)
    }
}