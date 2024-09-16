package com.dscoding.runique

import android.app.Application
import com.dscoding.auth.data.di.authDataModule
import com.dscoding.auth.presentation.di.authViewModelModule
import com.dscoding.core.data.di.coreDataModule
import com.dscoding.core.database.di.databaseModule
import com.dscoding.run.data.di.runDataModule
import com.dscoding.run.location.di.locationModule
import com.dscoding.run.network.di.networkModule
import com.dscoding.run.presentation.di.runPresentationModule
import com.dscoding.runique.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            workManagerFactory()
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule,
                networkModule,
                runDataModule
            )
        }
    }
}