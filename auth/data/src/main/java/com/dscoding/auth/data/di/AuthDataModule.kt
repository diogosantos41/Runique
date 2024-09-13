package com.dscoding.auth.data.di

import com.dscoding.auth.data.AuthRepositoryImpl
import com.dscoding.auth.data.EmailPatternValidator
import com.dscoding.auth.domain.AuthRepository
import com.dscoding.auth.domain.PatternValidator
import com.dscoding.auth.domain.UserDataValidator

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}