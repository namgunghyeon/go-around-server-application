package com.anyone.go_around_api.account.adapter.`in`.graphql

import com.anyone.go_around_api.account.adapter.`in`.web.AccountDtoMapper
import com.anyone.go_around_api.account.adapter.`in`.web.response.UserInfoDto
import com.anyone.go_around_api.account.application.service.AccountService
import com.anyone.go_around_api.account.application.service.GoAroundUserDetailService
import com.anyone.go_around_api.account.application.service.vo.TokenVo
import com.anyone.go_around_api.account.application.service.vo.UserInfoVo
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountQuery(
    private val accountService: AccountService,
    private val goAroundUserDetailService: GoAroundUserDetailService,
    private val accountDtoMapper: AccountDtoMapper
) {
    @QueryMapping
    @PreAuthorize("isAuthenticated()")
    fun me(): UserInfoDto {
        val email = goAroundUserDetailService.getCurrentUserEmail()
        val userInfoVo: UserInfoVo = accountService.me(email)
        return accountDtoMapper.toUserInfoDto(userInfoVo)
    }
}