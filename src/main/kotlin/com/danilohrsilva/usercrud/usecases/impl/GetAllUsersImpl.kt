package com.danilohrsilva.usercrud.usecases.impl

import com.danilohrsilva.usercrud.domain.User
import com.danilohrsilva.usercrud.usecases.GetAllUsers
import com.danilohrsilva.usercrud.usecases.gateways.UserGateway
import org.springframework.stereotype.Service

/**
 * See [GetAllUsers].
 */
@Service
class GetAllUsersImpl(private val userGateway: UserGateway) : GetAllUsers {

    override fun execute(): List<User> {
        return userGateway.getAllUsers()
    }

}
