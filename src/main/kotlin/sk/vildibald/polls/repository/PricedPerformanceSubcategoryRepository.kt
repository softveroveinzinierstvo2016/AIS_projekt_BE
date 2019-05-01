package sk.vildibald.polls.repository

import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sk.vildibald.polls.model.PricedPerformanceSubcategory

@Repository
interface PricedPerformanceSubcategoryRepository: JpaRepository<PricedPerformanceSubcategory, Long> {

    fun findByIdIn(userIds: Iterable<Long>): List<PricedPerformanceSubcategory>

    fun findByIdIn(typeIds: Iterable<Long>, sort: Sort): List<PricedPerformanceSubcategory>
}