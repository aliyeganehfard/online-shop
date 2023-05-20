package ir.onlineshop.controller

import ir.onlineshop.common.dto.CategorySaveDto
import ir.onlineshop.common.dto.mapper.BaseModelMapper
import ir.onlineshop.database.model.Category
import ir.onlineshop.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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


}