package com.dscoding.run.presentation.di

import com.dscoding.run.domain.RunningTracker
import com.dscoding.run.presentation.active_run.ActiveRunViewModel
import com.dscoding.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val runPresentationModule = module {
    singleOf(::RunningTracker)

    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}