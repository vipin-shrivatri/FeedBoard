package com.androidbc.feedboard.data.di

import com.androidbc.feedboard.data.remote.UserApiService
import com.androidbc.feedboard.data.repository.UserRepositoryImpl
import com.androidbc.feedboard.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    @Singleton
    fun provideUserRepository(api: UserApiService): UserRepository {
        return UserRepositoryImpl(api)
    }
}