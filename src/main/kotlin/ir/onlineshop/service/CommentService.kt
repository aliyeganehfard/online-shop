package ir.onlineshop.service

import ir.onlineshop.database.model.Comment

interface CommentService {

    fun save(comment: Comment)
}