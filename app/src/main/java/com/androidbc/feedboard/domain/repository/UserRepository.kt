package com.androidbc.feedboard.domain.repository

import com.androidbc.feedboard.domain.model.User
import com.androidbc.feedboard.domain.util.ApiResult

interface UserRepository {
    suspend fun getUsers(): ApiResult<List<User>>
}
