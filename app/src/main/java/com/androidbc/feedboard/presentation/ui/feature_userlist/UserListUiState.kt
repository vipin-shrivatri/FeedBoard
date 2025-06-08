package com.androidbc.feedboard.presentation.ui.feature_userlist

import com.androidbc.feedboard.domain.model.User

sealed class UserListUiState {
    data object Loading : UserListUiState()
    data class Success(val users: List<User>) : UserListUiState()
    data class Error(val message: String) : UserListUiState()
}
