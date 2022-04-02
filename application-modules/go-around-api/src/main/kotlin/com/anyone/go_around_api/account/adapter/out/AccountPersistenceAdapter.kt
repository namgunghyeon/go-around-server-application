package com.anyone.go_around_api.account.adapter.out

import com.anyone.go_around_api.account.application.port.out.NewAccountPort
import com.anyone.go_around_api.account.application.port.out.UpdateAccountPort
import org.springframework.stereotype.Service

@Service
class AccountPersistenceAdapter: NewAccountPort, UpdateAccountPort {
    override fun newAccount() {
        println("new account")
    }

    override fun updateAccount() {
        println("update account")
    }
}