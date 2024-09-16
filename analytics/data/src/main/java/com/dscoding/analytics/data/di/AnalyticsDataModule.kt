package com.dscoding.analytics.data.di

import com.dscoding.analytics.data.RoomAnalyticsRepository
import com.dscoding.analytics.domain.AnalyticsRepository
import com.dscoding.core.database.RunDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsModule = module {
    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
    single {
        get<RunDatabase>().analyticsDao
    }
}