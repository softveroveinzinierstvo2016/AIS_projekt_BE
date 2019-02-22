package sk.vildibald.polls.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.data.domain.Sort
import sk.vildibald.polls.model.PerformerStyle

@Repository
interface PerformerStyleRepository: JpaRepository<PerformerStyle, Long> {
    fun findByIdIn(styleIds: Iterable<Long>): List<PerformerStyle>

    fun findByIdIn(styleIds: Iterable<Long>, sort: Sort): List<PerformerStyle>
}