package com.example.geeks_mvvm.utel

import android.app.Application
import androidx.room.Database

import dagger.hilt.android.HiltAndroidApp
import androidx.room.Room
import com.example.geeks_mvvm.data.room.DatabaseAb


@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var appDatabase: DatabaseAb
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(applicationContext, DatabaseAb::class.java, "love-file")
            .allowMainThreadQueries().build()
    }
}