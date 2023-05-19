package ir.onlineshop.database.model

import ir.onlineshop.database.model.enums.ShopStatus
import jakarta.persistence.*

import org.hibernate.Hibernate
import java.time.LocalDateTime

@Entity
@Table(name = "SHOP_PROFILE")
data class ShopProfile(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    val id: Long? = null,

    @Column(name = "STATUS_START_DATE", nullable = false)
    var statusStartDate: LocalDateTime = LocalDateTime.now(),

    @Column(name = "STATUS_END_DATE")
    var statusEndDate: LocalDateTime? = null,

    @Column(name = "IS_ACTIVE", nullable = false)
    var active: Boolean = false,

    @Enumerated(EnumType.STRING)
    @Column(name = "SHOP_STATUS_ENUM", nullable = false)
    var status: ShopStatus = ShopStatus.AWAITING_CONFIRMATION,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "SHOP_ID", nullable = false)
    var shop: Shop = Shop()
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as ShopProfile

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , statusStartDate = $statusStartDate , statusEndDate = $statusEndDate , isActive = $active , status = $status , shop = $shop )"
    }
}
