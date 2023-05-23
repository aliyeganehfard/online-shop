package ir.onlineshop.controller

import ir.onlineshop.common.dto.mapper.BaseModelMapper
import ir.onlineshop.common.dto.product.ProductReqDto
import ir.onlineshop.database.model.Product
import ir.onlineshop.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("product/")
class ProductController @Autowired constructor(
    val productService: ProductService
){
    val mapper = BaseModelMapper()

    @PostMapping("save")
    fun save(@RequestBody req: ProductReqDto): ResponseEntity<String>{
        val product = mapper.toModel(req,Product::class.java)
        productService.save(product)
        return ResponseEntity("ok",HttpStatus.CREATED)
    }
}
