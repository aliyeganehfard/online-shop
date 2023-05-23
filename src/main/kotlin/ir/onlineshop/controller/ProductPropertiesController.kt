package ir.onlineshop.controller

import ir.onlineshop.common.dto.mapper.BaseModelMapper
import ir.onlineshop.common.dto.productProperties.ProductPropertiesDto
import ir.onlineshop.database.model.ProductProperties
import ir.onlineshop.service.ProductPropertiesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("productProperties/")
class ProductPropertiesController @Autowired constructor(
    val productPropertiesService: ProductPropertiesService
) {

    val mapper = BaseModelMapper()

    @PostMapping("save")
    fun save(@RequestBody req: List<ProductPropertiesDto>): ResponseEntity<String> {
        val productProperties = mapper.toModelList(req, ProductProperties::class.java)
        productPropertiesService.saveAll(productProperties)
        return ResponseEntity("ok", HttpStatus.CREATED)
    }
}