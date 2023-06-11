package ir.onlineshop.controller

import ir.onlineshop.common.dto.mapper.BaseModelMapper
import ir.onlineshop.common.dto.user.UserReqDto
import ir.onlineshop.database.model.User
import ir.onlineshop.database.repository.UserRepository
import ir.onlineshop.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("user/")
class UserController @Autowired constructor(
    private val userService: UserService,
    private val userRepository: UserRepository
) {

    private val mapper = BaseModelMapper()

    @GetMapping("findAll")
    fun findAll():List<User>{
        return userRepository.findAll()
    }
}