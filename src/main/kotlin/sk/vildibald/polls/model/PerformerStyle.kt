package sk.vildibald.polls.model


import org.hibernate.annotations.NaturalId
import javax.persistence.*


@Entity
@Table(name = "performer_styles")
data class PerformerStyle (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @NaturalId
    @Column(length = 60)
    val styleName: String
)