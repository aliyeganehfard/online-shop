package ir.onlineshop.service.impl

import ir.onlineshop.database.model.Comment
import ir.onlineshop.database.repository.CommentRepository
import ir.onlineshop.service.CommentService
import ir.onlineshop.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CommentServiceImpl @Autowired constructor(
    private val commentRepository: CommentRepository,
    private val productService: ProductService
) : CommentService {

    override fun save(comment: Comment) {
        val product = productService.findById(comment.product?.id!!)
        comment.product = product
        commentRepository.save(comment)
    }

    override fun findAll(): List<Comment> {
        return commentRepository.findAll()
    }
}