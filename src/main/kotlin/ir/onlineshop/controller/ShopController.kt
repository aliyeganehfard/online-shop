package ir.onlineshop.controller

import ir.onlineshop.common.dto.shop.ShopResDto
import ir.onlineshop.common.dto.mapper.BaseModelMapper
import ir.onlineshop.common.dto.shop.ShopReqDto
import ir.onlineshop.database.model.Shop
import ir.onlineshop.service.ShopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("shop/")
class ShopController @Autowired constructor(
    private val shopService: ShopService
) {
    private val mapper = BaseModelMapper()

    @PostMapping("save")
    fun save(@RequestBody reqDto: ShopReqDto): ResponseEntity<String> {
        val shop = mapper.toModel(reqDto, Shop::class.java)
        shopService.save(shop)
        return ResponseEntity("ok", HttpStatus.CREATED)
    }

    @GetMapping("findAll")
    fun findAll(): ResponseEntity<List<ShopResDto>> {
        val shops = shopService.findAll()
        val shopResDtoList = mapper.toDtoList(shops, ShopResDto::class.java)
        return ResponseEntity(shopResDtoList, HttpStatus.OK)
    }

    @GetMapping("findById/{id}")
    fun findById(@PathVariable(name = "id") id: Long): ResponseEntity<ShopResDto> {
        val shop = shopService.findById(id)
        val shopResDto = mapper.toDto(shop, ShopResDto::class.java)
        return ResponseEntity(shopResDto, HttpStatus.OK)
    }
}