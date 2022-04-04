package com.anyone.mysql_domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
class BaseEntity {
    @CreatedDate
    @Column(name = "created_at", insertable = false, updatable = false)
    lateinit var createdDateTime: LocalDateTime

    @LastModifiedDate
    @Column(name = "updated_at", insertable = false, updatable = false)
    lateinit var updatedDateTime: LocalDateTime
}