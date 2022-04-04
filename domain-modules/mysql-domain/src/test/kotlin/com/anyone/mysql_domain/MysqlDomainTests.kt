package com.anyone.mysql_domain

import com.anyone.mysql_domain.account.Account
import com.anyone.mysql_domain.account.AccountRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MysqlDomainTests @Autowired constructor(
    val accountRepository: AccountRepository
) {
    @Test
    fun `test account 레파지토리 테스트`() {
        val account: Account = accountRepository.save(
            Account(
                "test@gmail.com",
                "name",
                "password"
            )
        )

        Assertions.assertEquals("test@gmail.com", account.email)
        Assertions.assertEquals("name", account.username)
        Assertions.assertEquals("password", account.password)
    }
}