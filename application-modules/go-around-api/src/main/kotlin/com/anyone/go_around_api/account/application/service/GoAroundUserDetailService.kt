package com.anyone.go_around_api.account.application.service

import com.anyone.go_around_api.account.application.port.out.LoadAccountPort
import com.anyone.mysql_domain.account.Account
import com.anyone.type.account.GoAroundAccount
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class GoAroundUserDetailService(
    private val loadAccountPort: LoadAccountPort
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val account: Account = loadAccountPort.loadAccountByEmail(username)

        return GoAroundAccount(
            account.username,
            account.password,
            account.email
        )
    }
}