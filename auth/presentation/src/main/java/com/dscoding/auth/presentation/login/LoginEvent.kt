package com.dscoding.auth.presentation.login

import com.dscoding.core.presentation.ui.UiText

sealed interface LoginEvent {
    data object LoginSuccess : LoginEvent
    data class Error(val error: UiText) : LoginEvent
}