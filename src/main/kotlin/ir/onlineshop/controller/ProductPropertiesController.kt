package ir.onlineshop.controller

import ir.onlineshop.common.dto.mapper.BaseModelMapper
import ir.onlineshop.common.dto.productProperties.ProductPropertiesReqDto
import ir.onlineshop.common.dto.productProperties.ProductPropertiesResDto
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
    fun save(@RequestBody req: ProductPropertiesReqDto): ResponseEntity<String> {
        val properties = mapper.toModel(req, ProductProperties::class.java)
        productPropertiesService.save(properties)
        return ResponseEntity("ok", HttpStatus.CREATED)
    }

    //Todo get productId | shopId
    @PostMapping("saveAll")
    fun saveAll(@RequestBody req: List<ProductPropertiesReqDto>): ResponseEntity<String> {
        val productProperties = mapper.toModelList(req, ProductProperties::class.java)
        productPropertiesService.saveAll(productProperties)
        return ResponseEntity("ok", HttpStatus.CREATED)
    }

    @PutMapping("update")
    fun update(@RequestParam("propertiesId") propertiesId: Long,
               @RequestParam("value") value: String): ResponseEntity<String>{
        productPropertiesService.update(propertiesId, value)
        return ResponseEntity("ok",HttpStatus.CREATED)
    }

    @GetMapping("findById/{propertiesId}")
    fun findById(@PathVariable(value = "propertiesId") propertiesId: Long): ResponseEntity<ProductPropertiesResDto> {
        val properties = productPropertiesService.findById(propertiesId)
        val propertiesDto = mapper.toDto(properties, ProductPropertiesResDto::class.java)
        return ResponseEntity(propertiesDto, HttpStatus.OK)
    }

    @GetMapping("find/shop/properties/{shopId}")
    fun findShopProperties(@PathVariable(name = "shopId") shopId: Long): ResponseEntity<List<ProductPropertiesResDto>> {
        val properties = productPropertiesService.findShopProperties(shopId)
        val propertiesDto = mapper.toDtoList(properties, ProductPropertiesResDto::class.java)
        return ResponseEntity(propertiesDto, HttpStatus.OK)
    }
}