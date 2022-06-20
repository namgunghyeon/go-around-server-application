package com.anyone.go_around_api.account.adapter.out

import com.anyone.go_around_api.account.application.port.out.LoadAccountPort
import com.anyone.go_around_api.account.application.port.out.SaveAccountPort
import com.anyone.go_around_api.account.application.port.out.UpdateAccountPort
import com.anyone.mysql_domain.account.Account
import com.anyone.mysql_domain.account.AccountRepository
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class AccountPersistenceAdapter(
    private val accountRepository: AccountRepository
): SaveAccountPort, UpdateAccountPort, LoadAccountPort {
    override fun newAccount() {
        println("new account")
    }

    override fun updateAccount() {
        println("update account")
    }

    override fun loadAccountByEmail(email: String): Account {
        return accountRepository
            .findByEmail(email)?:
            throw UsernameNotFoundException("사용자를 찾지 못했습니다.")
    }
}