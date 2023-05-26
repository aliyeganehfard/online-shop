package ir.onlineshop.database.repository

import ir.onlineshop.database.model.ShopOwner
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopOwnerRepository: JpaRepository<ShopOwner,Long>