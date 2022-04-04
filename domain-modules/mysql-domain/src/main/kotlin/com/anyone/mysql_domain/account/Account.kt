package com.anyone.mysql_domain.account

import com.anyone.mysql_domain.BaseEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Account(
    email: String,
    username: String,
    password: String
): BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null;

    var email: String = email;
    var username: String  = username;
    val password: String = password;
}