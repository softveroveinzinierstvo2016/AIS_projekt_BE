package sk.vildibald.polls.model

import org.hibernate.annotations.NaturalId
import sk.vildibald.polls.model.audit.PersistableEntity
import javax.persistence.*

@Entity
@Table(name = "performance_subcategories")
data class PerformanceSubCategory (

        @NaturalId
        @Column(length = 60)
        val subcategoryName: String
) : PersistableEntity() {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    lateinit var category: PerformanceCategory
}