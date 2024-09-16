package com.dscoding.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dscoding.core.database.dao.AnalyticsDao
import com.dscoding.core.database.dao.RunDao
import com.dscoding.core.database.dao.RunPendingSyncDao
import com.dscoding.core.database.entity.DeletedRunSyncEntity
import com.dscoding.core.database.entity.RunEntity
import com.dscoding.core.database.entity.RunPendingSyncEntity

@Database(
    entities = [
        RunEntity::class,
        RunPendingSyncEntity::class,
        DeletedRunSyncEntity::class
    ],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {

    abstract val runDao: RunDao
    abstract val runPendingSyncDao: RunPendingSyncDao
    abstract val analyticsDao: AnalyticsDao
}