package com.anyone.go_around_api.account.adapter.`in`.web

import com.anyone.go_around_api.account.adapter.`in`.web.request.SignInDto
import com.anyone.go_around_api.account.adapter.`in`.web.request.SignUpDto
import com.anyone.go_around_api.account.application.port.out.SaveAccountPort
import com.anyone.go_around_api.account.application.port.out.UpdateAccountPort
import com.anyone.go_around_api.account.application.service.AccountService
import com.anyone.go_around_api.common.GoAroundV1APIController
import com.anyone.go_around_api.common.WebAdapter
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@WebAdapter
@GoAroundV1APIController
@RestController
class AccountController(
    private val accountService: AccountService,
    private val newAccountPort: SaveAccountPort,
    private val updateAccountPort: UpdateAccountPort
    ) {

    @PostMapping("/accounts/sign-up")
    fun signUp(@RequestBody signUpDto: SignUpDto): String {
        return "회원 가입";
    }

    @PostMapping("/accounts/sign-in")
    fun signIn(@RequestBody signInDto: SignInDto): String {
        return "login"
    }

    @PutMapping("/accounts/password")
    fun updatePassword(@RequestBody signInDto: SignInDto): String {
        return "login"
    }
}