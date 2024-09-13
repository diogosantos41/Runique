@file:OptIn(ExperimentalFoundationApi::class)

package com.dscoding.auth.presentation.login

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.TextFieldState

data class LoginState(
    val email: TextFieldState = TextFieldState(),
    val password: TextFieldState = TextFieldState(),
    val isLoggingIn: Boolean = false,
    val canLogin: Boolean = false
)


