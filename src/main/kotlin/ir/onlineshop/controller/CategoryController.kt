package ir.onlineshop.controller

import ir.onlineshop.common.dto.CategoryDto
import ir.onlineshop.common.dto.CategorySaveDto
import ir.onlineshop.common.dto.mapper.BaseModelMapper
import ir.onlineshop.database.model.Category
import ir.onlineshop.service.CategoryService
import org.apache.tomcat.util.http.parser.HttpParser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("category/")
class CategoryController @Autowired constructor(
    private val categoryService: CategoryService
){

    private val mapper = BaseModelMapper()

    @PostMapping("save")
    fun save(@RequestBody categorySaveDto: CategorySaveDto): ResponseEntity<String>{
        val category = mapper.toModel(categorySaveDto,Category::class.java)
        categoryService.save(category)
        return ResponseEntity("ok",HttpStatus.CREATED)
    }

    @GetMapping("findAll")
    fun findAll(): ResponseEntity<List<Category>>{
        val categoryList = categoryService.findAll()
//        val categoryDtoList = mapper.toDtoList(categoryList,CategoryDto::class.java)
        return ResponseEntity(categoryList,HttpStatus.OK)
    }
}