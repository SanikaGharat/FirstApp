package com.example.firstapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
sealed interface ColorDao{

    @Query("Select * from colors")
    suspend fun getAll(): Array<Color>

    @Insert
    suspend fun insert (vararg color:Color)
}