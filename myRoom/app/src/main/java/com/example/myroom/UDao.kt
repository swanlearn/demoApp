package com.example.myroom

import androidx.room.*

@Dao
interface UDao {
    @Query("SELECT * FROM iteam")
    fun getAll(): List<iteam>
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(item:iteam):Int
    @Insert()
    fun insert(item : iteam):Long
    @Query("DELETE FROM iteam WHERE id=:id")
    fun delete(id:Long)

}