package com.anyone.go_around_api

import com.anyone.go_around_jwt.GoAroundJwtApplication
import com.anyone.mysql_domain.MysqlDomainApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication(scanBasePackageClasses = [
    MysqlDomainApplication::class,
    GoAroundJwtApplication::class
])
class AnyOneApiServerApplication

fun main(args: Array<String>) {
    runApplication<AnyOneApiServerApplication>(*args)
}
