package ir.onlineshop.service.impl

import ir.onlineshop.common.dto.category.CategoryAddHolderDto
import ir.onlineshop.database.model.Category
import ir.onlineshop.database.repository.CategoryRepository
import ir.onlineshop.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl @Autowired constructor(
    private val categoryRepository: CategoryRepository
) : CategoryService {

    override fun save(category: Category) {
        categoryRepository.save(category)
    }

    override fun addCategory(categoryAddHolder: CategoryAddHolderDto) {
        val parentCategory = findById(categoryAddHolder.parentId!!)
        val category = Category().apply {
            this.title = categoryAddHolder.title!!
            this.parentCategory = parentCategory
        }
        categoryRepository.save(category)
    }

    override fun findAll(): List<Category> {
        return categoryRepository.findAll()
    }

    override fun findById(categoryId: Long): Category {
        return categoryRepository.findById(categoryId).orElseThrow { (Exception(categoryId.toString())) }
    }

}