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
import com.anyone.type.web.response.Response
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@WebAdapter
@GoAroundV1APIController
@RestController
class AccountController(
    private val accountService: AccountService,
    private val accountDtoMapper: AccountDtoMapper
    ) {

    @PostMapping("/accounts/sign-up")
    fun signUp(@RequestBody signUpDto: SignUpDto): Response<UserInfoDto> {
        val userInfoVo: UserInfoVo = accountService.signUp(signUpDto.email, signUpDto.password);

        return Response(accountDtoMapper.toUserInfoDto(userInfoVo))
    }

    @PostMapping("/accounts/sign-in")
    fun signIn(@RequestBody signInDto: SignInDto): Response<TokenDto> {
        val tokenVo: TokenVo = accountService.signIn(signInDto.email, signInDto.password)

        println("dfdfdtoken")
        println(tokenVo)
        return Response(accountDtoMapper.toTokenDto(tokenVo))
    }

    @GetMapping("/accounts/me")
    fun me(@CurrentAccount goAroundAccount: GoAroundAccount): Response<UserInfoDto> {
        val userInfoVo: UserInfoVo = accountService.me(goAroundAccount.username)

        return Response(accountDtoMapper.toUserInfoDto(userInfoVo))
    }

    @PutMapping("/accounts/password")
    fun updatePassword(@RequestBody signInDto: SignInDto): String {
        return "login"
    }
}