package com.anyone.mysql_domain.account

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface AccountRepository: JpaRepository<Account, Long> {
    fun findByEmail(email: String): Account?
    fun existsByEmail(email: String): Boolean
}