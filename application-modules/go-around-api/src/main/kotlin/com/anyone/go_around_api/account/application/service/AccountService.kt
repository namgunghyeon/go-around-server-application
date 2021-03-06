package com.anyone.go_around_api.account.application.service

import com.anyone.go_around_api.account.application.port.`in`.AccountUseCase
import com.anyone.go_around_api.account.application.port.out.LoadAccountPort
import com.anyone.go_around_api.account.application.port.out.SaveAccountPort
import com.anyone.go_around_api.account.application.service.vo.TokenVo
import com.anyone.go_around_api.account.application.service.vo.UserInfoVo
import com.anyone.go_around_jwt.token.JwtTokenProvider
import com.anyone.mysql_domain.account.Account
import com.anyone.type.web.exception.ExistsEmailException
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val passwordEncoder: PasswordEncoder,
    private val loadAccountPort: LoadAccountPort,
    private val saveAccountPort: SaveAccountPort,
    private val jwtTokenProvider: JwtTokenProvider,
    private val authenticationManager: AuthenticationManager
): AccountUseCase {
    override fun signIn(email: String, password: String): TokenVo {
        val authenticationToken = UsernamePasswordAuthenticationToken(email, password)
        val authentication = authenticationManager.authenticate(authenticationToken)
        SecurityContextHolder.getContext().authentication = authentication

        val accessToken: String = jwtTokenProvider.generateToken(email)
        val refreshToken: String = jwtTokenProvider.generateRefreshToken(accessToken)

        return TokenVo(accessToken, refreshToken)
    }

    override fun me(email: String): UserInfoVo {
        val account: Account = loadAccountPort
            .loadAccountByEmail(email)?:
        throw UsernameNotFoundException("사용자를 찾지 못했습니다.")

        return UserInfoVo(account.username, account.email)
    }

    override fun signUp(email: String, password: String): UserInfoVo {
        if (this.exists(email)) {
            throw ExistsEmailException("이미 존재하는 계정이 있습니다.")
        }
        val account = saveAccountPort.newAccount(email, passwordEncoder.encode(password))

        return UserInfoVo(account.username, account.email)
    }

    override fun updateProfile() {
        TODO("Not yet implemented")
    }

    override fun updatePassword() {
        TODO("Not yet implemented")
    }

    private fun exists(email: String): Boolean {
        return loadAccountPort.existsByEmail(email)
    }
}