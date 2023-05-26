package ir.onlineshop.controller

import ir.onlineshop.common.dto.mapper.BaseModelMapper
import ir.onlineshop.common.dto.user.UserReqDto
import ir.onlineshop.database.model.ShopOwner
import ir.onlineshop.service.ShopOwnerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("shop/owner/")
class ShopOwnerController @Autowired constructor(
    private val shopOwnerService: ShopOwnerService
) {

    private val mapper = BaseModelMapper()

    @PostMapping("save")
    fun save(@RequestBody req: UserReqDto): ResponseEntity<String> {
        val user = mapper.toModel(req, ShopOwner::class.java)
        shopOwnerService.save(user)
        return ResponseEntity("ok", HttpStatus.CREATED)
    }
}