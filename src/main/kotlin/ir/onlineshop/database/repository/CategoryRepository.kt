package ir.onlineshop.database.repository

import ir.onlineshop.database.model.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long> {

    @Query("SELECT c.childCategories FROM Category c WHERE c.id = :categoryId")
    fun findSubCategories(@Param(value = "categoryId") categoryId: Long): List<Category>
}