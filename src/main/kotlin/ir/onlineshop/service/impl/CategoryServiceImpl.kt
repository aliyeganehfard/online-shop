package ir.onlineshop.service.impl

import ir.onlineshop.common.dto.CategorySaveDto
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

    override fun findAll(): List<Category> {
        return categoryRepository.findAll()
    }

    private fun findById(categorySaveDto: CategorySaveDto) {
        categoryRepository.findById(categorySaveDto.id!!)
    }


}