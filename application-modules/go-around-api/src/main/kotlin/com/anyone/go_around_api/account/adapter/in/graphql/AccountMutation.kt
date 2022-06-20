package com.anyone.go_around_api.account.adapter.`in`.graphql

import com.anyone.go_around_api.account.adapter.`in`.web.AccountDtoMapper
import com.anyone.go_around_api.account.adapter.`in`.web.response.TokenDto
import com.anyone.go_around_api.account.application.service.AccountService
import com.anyone.go_around_api.account.application.service.vo.TokenVo
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountMutation(
    private val accountService: AccountService,
    private val accountDtoMapper: AccountDtoMapper
) {
    @MutationMapping
    fun sigIn(
        @Argument("email") email: String,
        @Argument("password") password: String
    ): TokenDto {
        val tokenVo: TokenVo = accountService.signIn(email, password)
        return accountDtoMapper.toTokenDto(tokenVo)
    }

}