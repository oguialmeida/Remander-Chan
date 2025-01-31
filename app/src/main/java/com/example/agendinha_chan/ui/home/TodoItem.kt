package com.example.agendinha_chan.ui.home

import java.time.LocalTime

data class TodoItem(
    val text: String,
    var isCompleted: Boolean = false,
    var time: LocalTime = LocalTime.now()
)
