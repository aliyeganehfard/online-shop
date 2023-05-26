package ir.onlineshop.controller

import ir.onlineshop.service.FavoriteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("favorite/")
class FavoriteController @Autowired constructor(
    private val favoriteService: FavoriteService
) {

    @PostMapping("save")
    fun save(
        @RequestParam(name = "userId") userId: Long,
        @RequestParam(name = "productId") productId: Long
    ): ResponseEntity<String> {
        favoriteService.save(userId, productId)
        return ResponseEntity("ok",HttpStatus.CREATED)
    }
}