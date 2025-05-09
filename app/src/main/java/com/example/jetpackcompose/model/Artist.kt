package com.example.jetpackcompose.model

data class Artist(
    val artistId: Int,
    val artistName: String,
    val artistImageUrl: String,
    val likesCount: Int,
    val averageRating: Float
)
