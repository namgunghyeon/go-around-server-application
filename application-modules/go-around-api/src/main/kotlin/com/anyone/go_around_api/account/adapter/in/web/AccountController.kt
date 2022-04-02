package com.anyone.go_around_api.account.adapter.`in`.web

import com.anyone.go_around_api.account.application.port.out.NewAccountPort
import com.anyone.go_around_api.account.application.port.out.UpdateAccountPort
import com.anyone.go_around_api.account.application.service.AccountService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController(
    private val accountService: AccountService,
    private val newAccountPort: NewAccountPort,
    private val updateAccountPort: UpdateAccountPort
    ) {

    @PostMapping("/accounts/sign-up")
    fun signUp(): String {
        return "회원 가입";
    }

    @PostMapping("/accounts/sign-in")
    fun signIn(): String {

        newAccountPort.newAccount();
        updateAccountPort.updateAccount();

        accountService.signIn();
        return "login"
    }
}