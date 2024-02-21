package com.example.rediexpress.ui.Authentication.viewmodel

import android.content.Context
import android.util.Patterns
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rediexpress.data.model.UserState
import com.example.rediexpress.data.network.SupabaseClient.client
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {

    private val _userState = mutableStateOf<UserState>(UserState.Loading)
    val userState: State<UserState> = _userState
    fun SignUp(
        context: Context,
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            try {
                client.auth.signUpWith(Email) {
                    this.email = email
                    this.password = password
                }
                _userState.value = UserState.Success("User Signed Up Successfully")
            } catch (e: Exception) {
                _userState.value = UserState.Error("Error ${e.message}")
            }
        }
    }
}
