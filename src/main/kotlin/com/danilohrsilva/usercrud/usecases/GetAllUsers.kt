package com.danilohrsilva.usercrud.usecases

import com.danilohrsilva.usercrud.domain.User

/**
 * Use case interface for retrieving all users.
 */
interface GetAllUsers {

    fun execute(): List<User>

}
