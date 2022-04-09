package com.anyone.mysql_domain.topic

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicRepository: JpaRepository<Topic, Long> {
}