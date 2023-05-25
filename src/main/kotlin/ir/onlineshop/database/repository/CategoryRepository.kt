package ir.onlineshop.database.repository

import ir.onlineshop.database.model.Category
import ir.onlineshop.database.repository.projections.MainCategory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long> {

    @Query("select NEW ir.onlineshop.database.repository.projections.MainCategory(c.id, c.title) From Category c WHERE c.parentCategory IS NULL")
    fun findMainCategory(): List<MainCategory>
}