package com.example.donutroomassignment

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DonutDao {

    @Insert
    suspend fun insert(donut: Donut)

    @Update
    suspend fun update(donut: Donut)

    @Delete
    suspend fun delete(donut: Donut)

    @Query("SELECT * FROM donut_table ORDER BY donutId DESC LIMIT 1")
    fun getLatest() : LiveData<List<Donut>>
}