package com.danilohrsilva.usercrud.entrypoints

import com.danilohrsilva.usercrud.domain.User
import com.danilohrsilva.usercrud.usecases.GetAllUsers
import com.nhaarman.mockito_kotlin.given
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.time.LocalDate

@RunWith(SpringRunner::class)
@WebMvcTest(controllers = [UserController::class], secure = false)
class UserControllerTest {

    @Autowired
    private lateinit var mvc: MockMvc

    @MockBean
    private lateinit var getAllUsers: GetAllUsers

    @Test
    fun getAllUsers() {
        val user1 = User(userName = "danilohrsilva", name = "Danilo", password = "pass123",
                passwordExpiringDate = LocalDate.of(1992, 8,15),
                email = "danilohrsilva@outlook.com", description = "A simple user")

        val user2 = User(userName = "drodrigues", name = "Rodrigues", password = "pass456",
                passwordExpiringDate = LocalDate.of(1995, 1,10),
                email = "danilohrsilva@outlook.com", description = null)

        given {
            getAllUsers.execute()

        }.willReturn(listOf(user1, user2))

        val expectedJson = "[{" +
                "userName: \"danilohrsilva\"," +
                "name: \"Danilo\"," +
                "password: \"pass123\"" +
                "}," +
                "{" +
                "userName: \"drodrigues\"," +
                "name: \"Rodrigues\"," +
                "password: \"pass456\"" +
                "}]"

        this.mvc.perform(get("/api/v1/users")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(header().string("Content-Type", "application/json;charset=UTF-8"))
                .andExpect(content().json(expectedJson, true))

    }

    @Test
    fun getAllUsersEmptyList() {

        given {
            getAllUsers.execute()

        }.willReturn(emptyList())

        val expectedJson = "[]"

        this.mvc.perform(get("/api/v1/users")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(header().string("Content-Type", "application/json;charset=UTF-8"))
                .andExpect(content().json(expectedJson, true))

    }

}
