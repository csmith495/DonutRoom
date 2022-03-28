package com.example.donutroomassignment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "donut_table")
data class Donut(

    @PrimaryKey(autoGenerate = true)
    var donutId : Long = 0L,

    @ColumnInfo(name = "donut_amount")
    var donutAmount : String = "",

    @ColumnInfo(name = "donut_date")
    var donutDate : String = ""
)
