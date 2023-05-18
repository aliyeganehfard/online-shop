package ir.onlineshop.database.repository

import ir.onlineshop.database.model.Shop
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopRepository:JpaRepository<Shop,Long>