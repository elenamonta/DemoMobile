package com.example.jetpackcompose.model

data class Event(
    val contentId: Int,
    val isTour: Boolean,
    val backgroundImageUrl: String,
    val title: String,
    val artistName: String,
    val artistImageUrl: String,
    val description: String,
    val date: String?
)
