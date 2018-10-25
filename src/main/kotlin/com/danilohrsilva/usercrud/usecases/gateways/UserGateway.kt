package com.danilohrsilva.usercrud.usecases.gateways

import com.danilohrsilva.usercrud.domain.User

/**
 * Interface Gateway for User.
 */
interface UserGateway {

    /**
     * Retrieves all users.
     */
    fun getAllUsers() : List<User>

}
