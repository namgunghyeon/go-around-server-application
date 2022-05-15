package com.anyone.go_around_api.account.application.service

import com.anyone.go_around_api.account.application.port.`in`.AccountUseCase
import com.anyone.go_around_api.account.application.port.out.LoadAccountPort
import com.anyone.go_around_api.account.application.service.vo.TokenVo
import com.anyone.go_around_api.account.application.service.vo.UserInfoVo
import com.anyone.go_around_jwt.token.JwtTokenProvider
import com.anyone.mysql_domain.account.Account
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val loadAccountPort: LoadAccountPort,
    private val jwtTokenProvider: JwtTokenProvider,
    private val authenticationManager: AuthenticationManager
): AccountUseCase {
    override fun signIn(email: String, password: String): TokenVo {
        val authenticationToken = UsernamePasswordAuthenticationToken(email, password)
        println(authenticationToken)
        val authentication = authenticationManager.authenticate(authenticationToken)
        println(authentication)
        SecurityContextHolder.getContext().authentication = authentication

        println("dfdfdfd")
        val accessToken: String = jwtTokenProvider.generateToken(email)
        println(accessToken)
        val refreshToken: String = jwtTokenProvider.generateRefreshToken(accessToken)

        return TokenVo(accessToken, refreshToken)
    }

    override fun me(email: String): UserInfoVo {
        val account: Account = loadAccountPort.loadAccountByEmail(email)

        return UserInfoVo(account.username, account.email)
    }

    override fun signUp() {
        TODO("Not yet implemented")
    }

    override fun updateProfile() {
        TODO("Not yet implemented")
    }

    override fun updatePassword() {
        TODO("Not yet implemented")
    }
}