package ir.onlineshop.database.repository

import ir.onlineshop.database.model.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository: JpaRepository<Category,Long>