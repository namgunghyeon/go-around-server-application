package com.anyone.go_around_api.account.adapter.out

import com.anyone.go_around_api.account.application.port.out.SaveAccountPort
import com.anyone.go_around_api.account.application.port.out.UpdateAccountPort
import com.anyone.mysql_domain.account.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountPersistenceAdapter(
    private val accountRepository: AccountRepository
): SaveAccountPort, UpdateAccountPort {
    override fun newAccount() {
        println("new account")
    }

    override fun updateAccount() {
        println("update account")
    }
}