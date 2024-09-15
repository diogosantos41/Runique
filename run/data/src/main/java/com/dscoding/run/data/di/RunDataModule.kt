package com.dscoding.run.data.di

import com.dscoding.core.domain.run.SyncRunScheduler
import com.dscoding.run.data.CreateRunWorker
import com.dscoding.run.data.DeleteRunWorker
import com.dscoding.run.data.FetchRunsWorker
import com.dscoding.run.data.SyncRunWorkerScheduler
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}