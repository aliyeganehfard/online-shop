package ir.onlineshop.controller

import ir.onlineshop.common.dto.favorite.FavoriteResDto
import ir.onlineshop.common.dto.mapper.BaseModelMapper
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

    val mapper = BaseModelMapper()

    @PostMapping("save")
    fun save(
        @RequestParam(name = "userId") userId: Long,
        @RequestParam(name = "productId") productId: Long
    ): ResponseEntity<String> {
        favoriteService.save(userId, productId)
        return ResponseEntity("ok",HttpStatus.CREATED)
    }

    @GetMapping("find/userFavorite/{userId}")
    fun findUserFavorite(@PathVariable(value = "userId") userId: Long): ResponseEntity<List<FavoriteResDto>>{
        val favorites = favoriteService.findUserFavorites(userId)
        val favoritesDto = mapper.toDtoList(favorites,FavoriteResDto::class.java)
        return ResponseEntity(favoritesDto,HttpStatus.OK)
    }
}