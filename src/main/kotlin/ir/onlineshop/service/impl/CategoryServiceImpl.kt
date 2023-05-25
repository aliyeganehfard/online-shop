package ir.onlineshop.service.impl

import ir.onlineshop.common.dto.category.CategoryAddHolderDto
import ir.onlineshop.database.model.Category
import ir.onlineshop.database.repository.CategoryRepository
import ir.onlineshop.database.repository.projections.MainCategory
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

    override fun findMainCategories(): List<MainCategory> {
        return categoryRepository.findMainCategories()
    }

    override fun findMainCategoryById(categoryId: Long): Category {
        categoryRepository.findMainCategoryById(categoryId).let {
            if (it == null)
                throw Exception("main category with id = $categoryId not found! ")
            else
                return it
        }
    }

}