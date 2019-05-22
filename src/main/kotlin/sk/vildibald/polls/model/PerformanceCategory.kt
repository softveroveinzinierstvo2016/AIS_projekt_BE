package sk.vildibald.polls.model

import org.hibernate.annotations.NaturalId
import javax.persistence.*

@Entity
@Table(name = "performance_categories")
data class PerformanceCategory(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @NaturalId
        @Column(length = 60)
        val categoryName: String,

        @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
        val subCategories: List<PerformanceSubCategory>
)