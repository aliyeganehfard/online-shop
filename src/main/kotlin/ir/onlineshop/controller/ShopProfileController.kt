package ir.onlineshop.controller

import ir.onlineshop.common.dto.ShopProfileDto
import ir.onlineshop.common.dto.mapper.BaseModelMapper
import ir.onlineshop.service.ShopProfileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("shop/profile/")
class ShopProfileController @Autowired constructor(
    private val shopProfileService: ShopProfileService
) {

    private val mapper = BaseModelMapper()

    @GetMapping("findAwaitingConfirmations")
    fun findAwaitingConfirmations(): ResponseEntity<List<ShopProfileDto>> {
        val shopProfiles = shopProfileService.findShopsWithAwaitingConfirmationsStatus()
        val shopProfilesDto = mapper.toDtoList(shopProfiles, ShopProfileDto::class.java)
        return ResponseEntity(shopProfilesDto, HttpStatus.OK)
    }

    @PostMapping("confirmRequest")
    fun confirmRequest(@RequestParam("shopId") shopId: Long): ResponseEntity<Boolean> {
        val isConfirmed = shopProfileService.confirmShopRequest(shopId)
        return ResponseEntity(isConfirmed, HttpStatus.OK)
    }

    @GetMapping("findAll")
    fun findAll(): ResponseEntity<List<ShopProfileDto>>{
        val shopProfileList = shopProfileService.findAll()
        val shopProfileDtoList = mapper.toDtoList(shopProfileList,ShopProfileDto::class.java)
        return ResponseEntity(shopProfileDtoList,HttpStatus.OK)
    }
}