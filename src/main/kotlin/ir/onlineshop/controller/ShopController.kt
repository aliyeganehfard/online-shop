package ir.onlineshop.controller

import ir.onlineshop.common.dto.shop.ShopDto
import ir.onlineshop.common.dto.mapper.BaseModelMapper
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
    fun save(@RequestBody shopDto: ShopDto): ResponseEntity<String> {
        val shop = mapper.toModel(shopDto, Shop::class.java)
        shopService.save(shop)
        return ResponseEntity("ok", HttpStatus.CREATED)
    }

    @GetMapping("findAll")
    fun findAll(): ResponseEntity<List<ShopDto>> {
        val shops = shopService.findAll()
        val shopDtoList = mapper.toDtoList(shops, ShopDto::class.java)
        return ResponseEntity(shopDtoList, HttpStatus.OK)
    }

    @GetMapping("findById/{id}")
    fun findById(@PathVariable(name = "id") id: Long): ResponseEntity<ShopDto> {
        val shop = shopService.findById(id)
        val shopDto = mapper.toDto(shop, ShopDto::class.java)
        return ResponseEntity(shopDto, HttpStatus.OK)
    }
}