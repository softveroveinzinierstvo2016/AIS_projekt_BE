package sk.vildibald.polls.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sk.vildibald.polls.model.PerformerType
import org.springframework.data.domain.Sort

@Repository
interface PerformerTypeRepository: JpaRepository<PerformerType, Long> {
    fun findByIdIn(typeIds: Iterable<Long>): List<PerformerType>

    fun findByIdIn(typeIds: Iterable<Long>, sort: Sort): List<PerformerType>

    fun findById(typeIds: List<Long>) : List<PerformerType>
}