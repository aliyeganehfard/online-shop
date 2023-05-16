package ir.onlineshop.controller

import ir.onlineshop.common.ShopDto
import ir.onlineshop.domein.model.Shop
import ir.onlineshop.service.ShopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("shop/")
class ShopController @Autowired constructor(
    private val shopService: ShopService
) {

    @PostMapping("save")
    fun save(@RequestBody shop: Shop) : String{
        shopService.save(shop)
        return shop.toString()
    }

    @GetMapping("findAll")
    fun findAll():List<Shop>{
        return shopService.findAll()
    }
}