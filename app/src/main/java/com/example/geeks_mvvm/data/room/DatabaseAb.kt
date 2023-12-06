package com.example.geeks_mvvm.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.geeks_mvvm.remote.LoveModel


@Database(entities = [LoveModel::class], version = 1)
abstract class DatabaseAb : RoomDatabase() {
    abstract fun getDao(): DaoDo
}
