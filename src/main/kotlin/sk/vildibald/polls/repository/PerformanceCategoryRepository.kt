package sk.vildibald.polls.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.data.domain.Sort
import sk.vildibald.polls.model.PerformanceCategory

@Repository
interface PerformanceCategoryRepository: JpaRepository<PerformanceCategory, Long> {
    fun findByIdIn(categoryIds: Iterable<Long>): List<PerformanceCategory>

    fun findByIdIn(categoryIds: Iterable<Long>, sort: Sort): List<PerformanceCategory>
}