package com.danilohrsilva.usercrud.respositories

import com.danilohrsilva.usercrud.domain.User
import com.danilohrsilva.usercrud.usecases.gateways.UserGateway
import org.springframework.stereotype.Repository
import java.time.LocalDate

/**
 * See [UserGateway].
 */
@Repository
class UserRepository : UserGateway {

    /**
     * * See getAllUsers from [UserGateway].
     */
    override fun getAllUsers(): List<User> {
        return listOf(User(userName = "danilohrsilva", name = "Danilo", password = "pass123",
                passwordExpiringDate = LocalDate.of(1992, 8,15),
                email = "danilohrsilva@outlook.com", description = "A simple user"))
    }

}
