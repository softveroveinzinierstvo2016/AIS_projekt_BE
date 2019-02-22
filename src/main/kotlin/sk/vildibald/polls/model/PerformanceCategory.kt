package sk.vildibald.polls.model

import org.hibernate.annotations.BatchSize
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.hibernate.annotations.NaturalId
import javax.persistence.*
import javax.validation.constraints.Size


@Entity
@Table(name = "performance_categories")
data class PerformanceCategory (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @NaturalId
        @Column(length = 60)
        val categoryName: String,

        @OneToMany(
                mappedBy = "category",
                cascade = [CascadeType.ALL],
                fetch = FetchType.EAGER,
                orphanRemoval = true
        )
        @Size(min = 2, max = 6)
        @Fetch(FetchMode.SELECT)
        @BatchSize(size = 30)
        val subCategories: List<PerformanceSubCategory> = listOf()
)