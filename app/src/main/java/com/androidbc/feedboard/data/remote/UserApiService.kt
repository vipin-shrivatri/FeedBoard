package com.androidbc.feedboard.data.remote

import com.androidbc.feedboard.domain.model.UserResponse
import retrofit2.http.GET

interface UserApiService {
    @GET("v3/bc77fc26-d695-4418-a11a-05e58689886b")
    suspend fun getUsers(): UserResponse
}

