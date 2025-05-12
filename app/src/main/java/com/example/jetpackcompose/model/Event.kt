package com.example.jetpackcompose.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(
    val contentId: Int,
    val isTour: Boolean,
    val backgroundImageUrl: String,
    val title: String,
    //val artistName: String,
    //val artistImageUrl: String,
    val artist: Artist,
    val description: String,
    val date: String?
) : Parcelable
