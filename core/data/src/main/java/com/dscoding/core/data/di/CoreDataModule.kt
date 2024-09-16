package com.dscoding.core.data.di

import com.dscoding.core.data.auth.EncryptedSessionStorage
import com.dscoding.core.data.networking.HttpClientFactory
import com.dscoding.core.data.run.OfflineFirstRunRepository
import com.dscoding.core.domain.SessionStorage
import com.dscoding.core.domain.run.RunRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()

    singleOf(::OfflineFirstRunRepository).bind<RunRepository>()
}