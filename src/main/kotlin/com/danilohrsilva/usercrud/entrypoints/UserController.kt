package com.danilohrsilva.usercrud.entrypoints

import com.danilohrsilva.usercrud.entrypoints.vo.UserSimpleVo
import com.danilohrsilva.usercrud.usecases.GetAllUsers
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private const val BASE_URI = "/api/v1/users"

@RestController
@RequestMapping(path = [BASE_URI], produces = [MediaType.APPLICATION_JSON_VALUE])
class UserController(private val getAllUsers: GetAllUsers) {

    @GetMapping
    fun getAllUsers(): List<UserSimpleVo> {
        return getAllUsers.execute().map {
            UserSimpleVo(it)
        }.toList()
    }

}
