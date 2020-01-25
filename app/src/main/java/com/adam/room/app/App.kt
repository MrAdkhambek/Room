package com.adam.room.app

import android.app.Application
import com.adam.room.db.AppDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        AppDatabase.init(this)
    }
}