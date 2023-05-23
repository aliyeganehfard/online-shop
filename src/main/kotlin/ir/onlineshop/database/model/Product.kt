package ir.onlineshop.database.model

import jakarta.persistence.*
import org.hibernate.Hibernate
import java.time.LocalDateTime

@Entity
@Table(name = "PRODUCT")
data class Product(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Long? = null,

    @Column(name = "CREATE_DATE")
    var createDate: LocalDateTime? = null,

    @Column(name = "UPDATE_DATE")
    var updateDate: LocalDateTime? = null,

    @Column(name = "NAME", nullable = false)
    var name: String = "",

    @Column(name = "DESCRIPTION", nullable = false)
    var description: String = "",

    @Column(name = "PRICE", nullable = false)
    var price: Long = 0,

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "PROPERTIES")
    var properties: List<ProductProperties> = mutableListOf(),

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "SHOP")
    var shop: Shop? = null

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
        other as Product

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , description = $description )"
    }
}
