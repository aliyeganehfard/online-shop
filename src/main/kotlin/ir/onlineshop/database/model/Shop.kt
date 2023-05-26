package ir.onlineshop.database.model

import jakarta.persistence.*
import org.hibernate.Hibernate
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import java.time.LocalDateTime

@Entity
@Table(name = "SHOP")
@DynamicInsert
@DynamicUpdate
data class Shop(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    var id: Long? = null,

    @Column(name = "CREATE_DATE")
    var createDate: LocalDateTime? = null,

    @Column(name = "UPDATE_DATE")
    var updateDate: LocalDateTime? = null,

    @Column(name = "NAME", nullable = false)
    var name: String = "",

    @Column(name = "LATIN_NAME", nullable = false)
    var latinName: String = "",

    @Column(name = "ABOUT")
    var about: String? = "",

    @Column(name = "ADDRESS")
    var address: String? = null,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY", nullable = false)
    var category: Category? = null,

    @OneToOne(mappedBy = "shop",fetch = FetchType.LAZY)
    var shopOwner: ShopOwner? = null
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
        other as Shop

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , createDate = $createDate , updateDate = $updateDate , name = $name , latinName = $latinName , about = $about , address = $address )"
    }

}
