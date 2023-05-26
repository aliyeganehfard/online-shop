package ir.onlineshop.database.repository

import ir.onlineshop.database.model.Favorite
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FavoriteRepository : JpaRepository<Favorite, Long>