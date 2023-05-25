package ir.onlineshop.database.model

import ir.onlineshop.database.model.enums.CommentScore
import jakarta.persistence.*
import org.hibernate.Hibernate
import java.time.LocalDateTime

@Entity
@Table(name = "COMMENT")
data class Comment(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Long? = null,

    @Column(name = "CREATE_DATE")
    var createDate: LocalDateTime? = null,

    @Column(name = "COMMENT_TEXT")
    var comment: String? = null,

    @Column(name = "SCORE")
    var score: CommentScore? = null,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "PRODUCT", nullable = false)
    var product: Product? = null
) {
    @PrePersist
    fun setCreateDate() {
        val now = LocalDateTime.now()
        this.createDate = now
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Comment

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , createDate = $createDate , comment = $comment , score = $score )"
    }
}
