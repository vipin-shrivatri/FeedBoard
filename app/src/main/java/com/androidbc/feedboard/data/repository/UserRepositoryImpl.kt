package com.androidbc.feedboard.data.repository

import com.androidbc.feedboard.data.remote.UserApiService
import com.androidbc.feedboard.domain.model.User
import com.androidbc.feedboard.domain.repository.UserRepository
import com.androidbc.feedboard.domain.util.ApiResult
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApiService
) : UserRepository {

    override suspend fun getUsers(): ApiResult<List<User>> {
        return try {
            val response = api.getUsers()
            ApiResult.Success(response.users)
        } catch (e: Exception) {
            ApiResult.Error(
                message = e.localizedMessage ?: "An unexpected error occurred",
                throwable = e
            )
        }
    }
}
