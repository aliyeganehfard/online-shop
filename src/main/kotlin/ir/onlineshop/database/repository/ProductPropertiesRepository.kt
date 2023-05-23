package ir.onlineshop.database.repository

import ir.onlineshop.database.model.ProductProperties
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductPropertiesRepository: JpaRepository<ProductProperties,Long>