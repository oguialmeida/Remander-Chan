package com.example.agendinha_chan.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "diary_entries")
data class DiaryEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val date: Date,
    val content: String,
    val mood: Mood,
    val weather: Weather,
    val tags: List<String> = emptyList(),
    val images: List<String> = emptyList()
)

enum class Mood {
    VERY_HAPPY,
    HAPPY,
    NEUTRAL,
    SAD,
    VERY_SAD
}

enum class Weather {
    SUNNY,
    CLOUDY,
    RAINY,
    SNOWY,
    WINDY
}
