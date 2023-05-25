package ir.onlineshop.database.model

import jakarta.persistence.*
import org.hibernate.Hibernate

@Entity
@Table(name = "PRODUCT_PROPERTIES")
data class ProductProperties(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Long? = null,

    @Column(name = "PRODUCT_TITLE", nullable = false)
    var title: String = "",

    @Column(name = "PRODUCT_VALUE", nullable = false)
    var value: String = "",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    var product: Product? = null

) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as ProductProperties

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , title = $title , value = $value )"
    }
}
