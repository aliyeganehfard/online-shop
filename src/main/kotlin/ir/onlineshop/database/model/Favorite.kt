package ir.onlineshop.database.model

import jakarta.persistence.*
import org.hibernate.Hibernate
import java.time.LocalDateTime

@Entity
@Table(name = "FAVORITE")
data class Favorite(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Long? = null,

    @Column(name = "CREATE_DATE")
    var createDate: LocalDateTime? = null,

    @Column(name = "UPDATE_DATE")
    var updateDate: LocalDateTime? = null,

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    var user: User? = null,

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    var product: Product? = null

) {
    @PrePersist
    fun setCreateDate() {
        val now = LocalDateTime.now()
        this.createDate = now
        this.updateDate = now
    }

    @PreUpdate
    fun setUpdateDate() {
        this.updateDate = LocalDateTime.now()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Favorite

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , createDate = $createDate , updateDate = $updateDate , user = $user , product = $product )"
    }
}
