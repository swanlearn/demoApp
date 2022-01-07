package com.example.myroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class iteam(

    @PrimaryKey(autoGenerate = true) var id:Long = 0,
    @ColumnInfo(name = "String") var name:String)