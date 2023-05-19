package ir.onlineshop.controller

import ir.onlineshop.common.dto.ShopProfileDto
import ir.onlineshop.common.dto.mapper.BaseModelMapper
import ir.onlineshop.service.ShopProfileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("shop/profile/")
class ShopProfileController @Autowired constructor(
    private val shopProfileService: ShopProfileService
){

    private val mapper = BaseModelMapper()

    @GetMapping("findAwaitingConfirmations")
    fun findAwaitingConfirmations() : ResponseEntity<List<ShopProfileDto>>{
        val shopProfiles = shopProfileService.findShopsWithAwaitingConfirmationsStatus()
        val shopProfilesDto = mapper.toDtoList(shopProfiles,ShopProfileDto::class.java)
        return ResponseEntity(shopProfilesDto,HttpStatus.OK)
    }
}