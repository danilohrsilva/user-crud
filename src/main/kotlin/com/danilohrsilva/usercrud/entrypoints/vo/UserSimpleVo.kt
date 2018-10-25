package com.danilohrsilva.usercrud.entrypoints.vo

import com.danilohrsilva.usercrud.domain.User

data class UserSimpleVo(
        val userName: String,
        val name: String,
        val password: String) {
    constructor(user: User): this(
            userName = user.userName,
            name = user.name,
            password = user.password
    )
}
