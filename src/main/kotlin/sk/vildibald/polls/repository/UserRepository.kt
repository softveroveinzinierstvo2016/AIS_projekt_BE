package sk.vildibald.polls.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import sk.vildibald.polls.model.User

@Repository
interface UserRepository : JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    fun findOneByUsername(username: String): User?

    fun findOneByUsernameOrEmail(username: String, email: String): User?

    fun existsByUsername(username: String): Boolean

    fun existsByEmail(email: String): Boolean

    @Query("select u from User u where u.isSolo = :isSolo and u.name like %:substringOfName% " +
            "and exists(select 'found' from u.performerType t where t.id in(:possibleTypes)) and exists(select 'found' from u.performerStyle t where t.id in(:possibleStyles))")
    fun find(@Param("isSolo") isSolo: Boolean,
             @Param("substringOfName") substringOfName: String,
             @Param("possibleTypes")possibleTypes: List<Long>,
             @Param("possibleStyles")possibleStyles: List<Long>): List<User>
}