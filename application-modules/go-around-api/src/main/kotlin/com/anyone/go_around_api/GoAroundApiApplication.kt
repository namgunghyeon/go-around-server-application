package com.anyone.go_around_api

import com.anyone.go_around_jwt.GoAroundJwtApplication
import com.anyone.mysql_domain.MysqlDomainApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import com.anyone.type.TypeApplication


@SpringBootApplication(scanBasePackageClasses = [
    AnyOneApiServerApplication::class,
    MysqlDomainApplication::class,
    GoAroundJwtApplication::class,
    TypeApplication::class
])
class AnyOneApiServerApplication

fun main(args: Array<String>) {
    runApplication<AnyOneApiServerApplication>(*args)
}
