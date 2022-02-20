package com.anyone.anyoneapiserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AnyOneApiServerApplication

fun main(args: Array<String>) {
    runApplication<AnyOneApiServerApplication>(*args)
}
