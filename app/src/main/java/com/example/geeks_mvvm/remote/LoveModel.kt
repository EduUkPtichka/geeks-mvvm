package com.example.geeks_mvvm.remote

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("love-table")
data class LoveModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val fname: String,
    val sname: String,
    val percentage: String,
    val result: String,
) {
    override fun toString(): String {
        return "\n$percentage \n$fname \n$sname \n$result\n"
    }
}
