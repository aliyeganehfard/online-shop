package ir.onlineshop.controller

import ir.onlineshop.common.dto.mapper.BaseModelMapper
import ir.onlineshop.common.dto.productProperties.ProductPropertiesDto
import ir.onlineshop.database.model.ProductProperties
import ir.onlineshop.service.ProductPropertiesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("productProperties/")
class ProductPropertiesController @Autowired constructor(
    val productPropertiesService: ProductPropertiesService
) {

    val mapper = BaseModelMapper()

    @PostMapping("save")
    fun save(@RequestBody req: ProductPropertiesDto): ResponseEntity<String> {
        val properties = mapper.toModel(req, ProductProperties::class.java)
        productPropertiesService.save(properties)
        return ResponseEntity("ok", HttpStatus.CREATED)
    }

    //Todo get productId | shopId
    @PostMapping("saveAll")
    fun saveAll(@RequestBody req: List<ProductPropertiesDto>): ResponseEntity<String> {
        val productProperties = mapper.toModelList(req, ProductProperties::class.java)
        productPropertiesService.saveAll(productProperties)
        return ResponseEntity("ok", HttpStatus.CREATED)
    }

    @GetMapping("find/shop/properties/{shopId}")
    fun findShopProperties(@PathVariable(name = "shopId") shopId: Long): ResponseEntity<List<ProductPropertiesDto>> {
        val properties = productPropertiesService.findShopProperties(shopId)
        val propertiesDto = mapper.toDtoList(properties, ProductPropertiesDto::class.java)
        return ResponseEntity(propertiesDto, HttpStatus.OK)
    }
}