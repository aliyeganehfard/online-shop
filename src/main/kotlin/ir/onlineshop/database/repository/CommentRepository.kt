package ir.onlineshop.database.repository

import ir.onlineshop.database.model.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository:JpaRepository<Comment,Long>