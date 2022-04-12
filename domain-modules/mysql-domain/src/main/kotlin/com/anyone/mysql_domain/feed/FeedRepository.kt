package com.anyone.mysql_domain.feed

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FeedRepository: JpaRepository<Feed, Long> {
    fun findAllByAccountId(accountId: Long): List<Feed>
}