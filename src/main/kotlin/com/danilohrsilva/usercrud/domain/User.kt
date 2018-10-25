package com.danilohrsilva.usercrud.domain

import java.time.LocalDate

/**
 * Domain class for [User]
 */
data class User(
        val userName: String,
        val name: String,
        val password: String,
        val passwordExpiringDate: LocalDate,
        val email: String?,
        val description: String?
)
