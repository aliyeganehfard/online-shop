package ir.onlineshop.database.model

import jakarta.persistence.Entity
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "SHOP_OWNER")
class ShopOwner: User() {

    @OneToOne
    var shop: Shop? = null
}