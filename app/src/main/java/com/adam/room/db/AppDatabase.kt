package com.adam.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.adam.room.constants.ROOM_DATABASE_NAME
import com.adam.room.db.dao.PhoneDao
import com.adam.room.db.table.PhoneData


@Database(entities = [PhoneData::class], version = 1)
abstract class AppDatabaseImpl : RoomDatabase() {

    abstract val taskDao: PhoneDao
}


object AppDatabase {

    private var databaseImpl: AppDatabaseImpl? = null

    val INSTANCE: AppDatabaseImpl
        get() = databaseImpl ?: throw NullPointerException("App database not initialized.")


    fun init(context: Context) {
        databaseImpl = Room.databaseBuilder(
            context.applicationContext,
            AppDatabaseImpl::class.java,
            ROOM_DATABASE_NAME
        ).build()
    }
}