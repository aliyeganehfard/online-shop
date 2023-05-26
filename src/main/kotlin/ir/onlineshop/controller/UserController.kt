package ir.onlineshop.controller

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
@RequestMapping("user/")
class UserController @Autowired constructor(
    private val userService: UserService
) {

    private val mapper = BaseModelMapper()

    @PostMapping("save")
    fun save(@RequestBody req: UserReqDto): ResponseEntity<String> {
        val user = mapper.toModel(req, User::class.java)
        userService.save(user)
        return ResponseEntity("ok", HttpStatus.CREATED)
    }
}