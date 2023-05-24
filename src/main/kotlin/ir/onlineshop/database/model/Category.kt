package ir.onlineshop.database.model

import jakarta.persistence.*
import org.hibernate.Hibernate

@Entity
@Table(name = "CATEGORY")
data class Category(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Long? = null,

    @Column(name = "TITLE", nullable = false)
    var title: String = "",

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "PARENT_CATEGORY_ID")
    var parentCategory: Category? = null,

    @OneToMany(mappedBy = "parentCategory", cascade = [CascadeType.ALL], orphanRemoval = true)
    var childCategories: MutableList<Category> = mutableListOf()


) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Category

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , title = $title )"
    }

}
