package com.anyone.anyoneapiserver.account.adapter.out

import com.anyone.anyoneapiserver.account.application.port.out.NewAccountPort
import com.anyone.anyoneapiserver.account.application.port.out.UpdateAccountPort
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