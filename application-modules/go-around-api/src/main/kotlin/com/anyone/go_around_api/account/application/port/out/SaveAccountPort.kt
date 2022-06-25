package com.anyone.go_around_api.account.application.port.out

import com.anyone.mysql_domain.account.Account

interface SaveAccountPort {
    fun newAccount(email: String, password: String): Account
}