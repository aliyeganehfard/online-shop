package ir.onlineshop.controller

import ir.onlineshop.common.dto.comment.CommentReqDto
import ir.onlineshop.common.dto.mapper.BaseModelMapper
import ir.onlineshop.database.model.Comment
import ir.onlineshop.service.CommentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("comment/")
class CommentController @Autowired constructor(
    private val commentService: CommentService
) {

    private val mapper = BaseModelMapper()

    @PostMapping("save")
    fun save(@RequestBody req: CommentReqDto): ResponseEntity<String> {
        val comment = mapper.toModel(req, Comment::class.java)
        commentService.save(comment)
        return ResponseEntity("ok", HttpStatus.CREATED)
    }
}