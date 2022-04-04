package com.anyone.mysql_domain.account

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository: JpaRepository<Account, Long> {
}