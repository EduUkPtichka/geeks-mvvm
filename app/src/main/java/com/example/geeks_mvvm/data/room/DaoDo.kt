package com.example.geeks_mvvm.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.geeks_mvvm.remote.LoveModel

@Dao
interface DaoDo {
    @Insert
    fun insert(LoveModel_: LoveModel)
    @Query("SELECT * FROM `love-table` ORDER BY fname ASC")
    fun getAll(): List<LoveModel>
}