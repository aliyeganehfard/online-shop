package ir.onlineshop.domein.repository

import ir.onlineshop.domein.model.Shop
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopRepository:JpaRepository<Shop,Long>