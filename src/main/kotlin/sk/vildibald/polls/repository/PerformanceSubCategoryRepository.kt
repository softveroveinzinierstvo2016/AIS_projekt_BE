package sk.vildibald.polls.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import sk.vildibald.polls.model.PerformanceSubCategory

@Repository
interface PerformanceSubCategoryRepository : JpaRepository<PerformanceSubCategory, Long> {

    @Query(value = "SELECT s FROM PerformanceSubCategory s where s.category.id in :categoryIds")
    fun findByCategoryIdIn(@Param("categoryIds") categoryIds: Iterable<Long>): List<PerformanceSubCategory>
}