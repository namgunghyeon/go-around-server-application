package com.anyone.go_around_api.account.application.port.`in`

import com.anyone.go_around_api.account.application.service.vo.TokenVo
import com.anyone.go_around_api.account.application.service.vo.UserInfoVo

interface AccountUseCase {
    fun signIn(email: String, password: String): TokenVo
    fun signUp(email: String, password: String): UserInfoVo
    fun me(email: String): UserInfoVo
    fun updateProfile()
    fun updatePassword()
}