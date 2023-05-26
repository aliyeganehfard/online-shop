package ir.onlineshop.database.repository.projections

data class UserFavorites(
    var productId: Long,
    var productName: String,
    var productPrice: Long,
    var shopName: String,
)