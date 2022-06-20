package com.anyone.go_around_api.account.application.service

import com.anyone.go_around_api.account.application.port.out.LoadAccountPort
import com.anyone.mysql_domain.account.Account
import com.anyone.type.account.GoAroundAccount
import org.springframework.security.authentication.AnonymousAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Predicate

@Service
class GoAroundUserDetailService(
    private val loadAccountPort: LoadAccountPort
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val account: Account = loadAccountPort.loadAccountByEmail(username)

        return GoAroundAccount(
            account.id!!,
            account.username,
            account.password,
            account.email
        )
    }

    fun isAuthenticated(): Boolean {
        return Optional
            .ofNullable(SecurityContextHolder.getContext())
            .map { obj: SecurityContext -> obj.authentication }
            .filter(Authentication::isAuthenticated)
            .filter(Predicate.not(this::isAnonymous))
            .isPresent
    }

    private fun isAnonymous(authentication: Authentication): Boolean {
        return authentication is AnonymousAuthenticationToken
    }

}