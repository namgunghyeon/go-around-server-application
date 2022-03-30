package com.anyone.anyoneapiserver.account.adapter.`in`.web

import com.anyone.anyoneapiserver.account.application.port.out.NewAccountPort
import com.anyone.anyoneapiserver.account.application.port.out.UpdateAccountPort
import com.anyone.anyoneapiserver.account.application.service.AccountService
import org.springframework.web.bind.annotation.GetMapping
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