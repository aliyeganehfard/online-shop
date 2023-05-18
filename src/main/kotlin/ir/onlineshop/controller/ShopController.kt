package ir.onlineshop.controller

import ir.onlineshop.common.dto.ShopDto
import ir.onlineshop.database.model.Shop
import ir.onlineshop.service.ShopService
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("shop/")
class ShopController @Autowired constructor(
    private val shopService: ShopService
) {

    private val modelMapper: ModelMapper = ModelMapper()

    @PostMapping("save")
    fun save(@RequestBody shopDto: ShopDto): String? {
        val shop = modelMapper.map(shopDto, Shop::class.java)
        shopService.save(shop)
        return "ok"
    }

    @GetMapping("findAll")
    fun findAll():List<ShopDto>{
        return shopService.findAll().asSequence()
            .map { modelMapper.map(it,ShopDto::class.java) }
            .toList()
    }
}