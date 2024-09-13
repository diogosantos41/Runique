package com.dscoding.auth.presentation.register

import com.dscoding.core.presentation.ui.UiText

sealed interface RegisterEvent {
    data object RegistrationSuccess : RegisterEvent
    data class Error(val error: UiText) : RegisterEvent

}