package com.example.agendinha_chan.data

import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.*

@Dao
interface DiaryDao {
    @Query("SELECT * FROM diary_entries ORDER BY date DESC")
    fun getAllEntries(): LiveData<List<DiaryEntry>>

    @Query("SELECT * FROM diary_entries WHERE date = :date")
    suspend fun getEntryByDate(date: Date): DiaryEntry?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entry: DiaryEntry)

    @Update
    suspend fun update(entry: DiaryEntry)

    @Delete
    suspend fun delete(entry: DiaryEntry)

    @Query("SELECT * FROM diary_entries WHERE date BETWEEN :startDate AND :endDate ORDER BY date DESC")
    fun getEntriesBetweenDates(startDate: Date, endDate: Date): LiveData<List<DiaryEntry>>
}
