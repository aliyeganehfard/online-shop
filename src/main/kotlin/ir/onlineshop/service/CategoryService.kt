package ir.onlineshop.service

import ir.onlineshop.common.dto.category.CategoryAddHolderDto
import ir.onlineshop.database.model.Category

interface CategoryService {

    fun save(category: Category)

    fun addCategory(categoryAddHolder: CategoryAddHolderDto)

    fun findAll(): List<Category>

    fun findById(categoryId: Long): Category
}