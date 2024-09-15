package com.dscoding.run.network.di

import com.dscoding.core.domain.run.RemoteRunDataSource
import com.dscoding.run.network.KtorRemoteRunDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    singleOf(::KtorRemoteRunDataSource).bind<RemoteRunDataSource>()
}