package com.danilohrsilva.usercrud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

/**
 * Spring Application.
 */
@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class UserCrudApplication

/**
 * Init Spring.
 */
fun main(args: Array<String>) {
    runApplication<UserCrudApplication>(*args)
}
