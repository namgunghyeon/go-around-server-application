package com.anyone.go_around_api.account.adapter.`in`.web

import com.anyone.go_around_api.account.adapter.`in`.web.response.TokenDto
import com.anyone.go_around_api.account.adapter.`in`.web.response.UserInfoDto
import com.anyone.go_around_api.account.application.service.vo.TokenVo
import com.anyone.go_around_api.account.application.service.vo.UserInfoVo
import com.anyone.go_around_api.common.Mapper

@Mapper
class AccountDtoMapper {
    fun toTokenDto(tokenVo: TokenVo): TokenDto {
        return TokenDto(tokenVo.accessToken, tokenVo.refreshToken)
    }

    fun toUserInfoDto(userInfoVo: UserInfoVo): UserInfoDto {
        return UserInfoDto(userInfoVo.name, userInfoVo.email)
    }
}