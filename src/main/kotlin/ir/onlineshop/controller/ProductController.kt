package ir.onlineshop.controller

import ir.onlineshop.common.dto.mapper.BaseModelMapper
import ir.onlineshop.common.dto.product.ProductReqDto
import ir.onlineshop.common.dto.product.ProductResDto
import ir.onlineshop.database.model.Product
import ir.onlineshop.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("product/")
class ProductController @Autowired constructor(
    val productService: ProductService
) {
    val mapper = BaseModelMapper()

    @PostMapping("save")
    fun save(@RequestBody req: ProductReqDto): ResponseEntity<String> {
        val product = mapper.toModel(req, Product::class.java)
        productService.save(product)
        return ResponseEntity("ok", HttpStatus.CREATED)
    }

    @GetMapping("find/shop/products/{shopId}")
    fun findShopProducts(@PathVariable(name = "shopId") shopId: Long): ResponseEntity<List<ProductResDto>> {
        val products = productService.findShopProducts(shopId)
        val productsDto = mapper.toDtoList(products, ProductResDto::class.java)
        return ResponseEntity(productsDto, HttpStatus.OK)
    }

    @GetMapping("findAll")
    fun findAll(): ResponseEntity<List<ProductResDto>>{
        val products = productService.findAll()
        val productsDto = mapper.toDtoList(products,ProductResDto::class.java)
        return ResponseEntity(productsDto,HttpStatus.OK)
    }
}
