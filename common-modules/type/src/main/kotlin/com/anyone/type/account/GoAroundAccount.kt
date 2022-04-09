package com.anyone.type.account

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails

class GoAroundAccount(username: String, password: String, email: String) :
    User(username, password, arrayListOf()) {
    
    fun getGoAroundAccount(): GoAroundAccount {
        return this;
    }
}