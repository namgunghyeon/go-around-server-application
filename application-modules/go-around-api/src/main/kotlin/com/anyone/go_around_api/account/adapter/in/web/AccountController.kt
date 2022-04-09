package com.anyone.go_around_api.account.adapter.`in`.web

import com.anyone.go_around_api.account.adapter.`in`.web.request.SignInDto
import com.anyone.go_around_api.account.adapter.`in`.web.request.SignUpDto
import com.anyone.go_around_api.account.adapter.`in`.web.response.TokenDto
import com.anyone.go_around_api.account.adapter.`in`.web.response.UserInfoDto
import com.anyone.go_around_api.account.application.service.AccountService
import com.anyone.go_around_api.account.application.service.vo.TokenVo
import com.anyone.go_around_api.account.application.service.vo.UserInfoVo
import com.anyone.go_around_api.common.GoAroundV1APIController
import com.anyone.go_around_api.common.WebAdapter
import com.anyone.type.account.CurrentAccount
import com.anyone.type.account.GoAroundAccount
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@WebAdapter
@GoAroundV1APIController
@RestController
class AccountController(
    private val accountService: AccountService
    ) {

    @PostMapping("/accounts/sign-up")
    fun signUp(@RequestBody signUpDto: SignUpDto): String {
        return "회원 가입";
    }

    @PostMapping("/accounts/sign-in")
    fun signIn(@RequestBody signInDto: SignInDto): TokenDto {
        val tokenVo: TokenVo = accountService.signIn(signInDto.email, signInDto.password)

        return TokenDto(tokenVo.accessToken, tokenVo.refreshToken)
    }

    @GetMapping("/accounts/me")
    fun me(@CurrentAccount goAroundAccount: GoAroundAccount): UserInfoDto {
        val userInfoVo: UserInfoVo = accountService.me(goAroundAccount.username)

        return UserInfoDto(userInfoVo.name, userInfoVo.email)
    }

    @PutMapping("/accounts/password")
    fun updatePassword(@RequestBody signInDto: SignInDto): String {
        return "login"
    }
}