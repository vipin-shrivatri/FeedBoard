package com.androidbc.feedboard.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidbc.feedboard.domain.repository.UserRepository
import com.androidbc.feedboard.domain.util.ApiResult
import com.androidbc.feedboard.presentation.ui.feature_userlist.UserListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UserListUiState>(UserListUiState.Loading)
    val uiState: StateFlow<UserListUiState> = _uiState

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            when (val result = repository.getUsers()) {
                is ApiResult.Success -> {
                    _uiState.value = UserListUiState.Success(result.data)
                }

                is ApiResult.Error -> {
                    _uiState.value = UserListUiState.Error(result.message)
                }
            }
        }
    }
}
