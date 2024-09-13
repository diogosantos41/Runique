package com.dscoding.auth.presentation.di

import com.dscoding.auth.presentation.login.LoginViewModel
import com.dscoding.auth.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val authViewModelModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}