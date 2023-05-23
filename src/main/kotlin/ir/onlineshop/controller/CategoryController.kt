package ir.onlineshop.controller

import ir.onlineshop.common.dto.category.CategoryReqDto
import ir.onlineshop.common.dto.category.CategoryResDto
import ir.onlineshop.common.dto.mapper.BaseModelMapper
import ir.onlineshop.database.model.Category
import ir.onlineshop.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("category/")
class CategoryController @Autowired constructor(
    private val categoryService: CategoryService
) {

    private val mapper = BaseModelMapper()

    @PostMapping("save")
    fun save(@RequestBody categoryReqDto: CategoryReqDto): ResponseEntity<String> {
        val category = mapper.toModel(categoryReqDto, Category::class.java)
        categoryService.save(category)
        return ResponseEntity("ok", HttpStatus.CREATED)
    }

    @GetMapping("findAll")
    fun findAll(): ResponseEntity<List<CategoryResDto>> {
        val categoryList = categoryService.findAll()
        val categoryDtoList = mapper.toDtoList(categoryList, CategoryResDto::class.java)
        return ResponseEntity(categoryDtoList, HttpStatus.OK)
    }
}