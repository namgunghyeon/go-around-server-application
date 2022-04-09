package com.anyone.go_around_api.account.application.port.out

import com.anyone.mysql_domain.account.Account

interface LoadAccountPort {
    fun loadAccountByEmail(email: String): Account
}