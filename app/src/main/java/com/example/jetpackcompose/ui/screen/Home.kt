package com.example.jetpackcompose.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.jetpackcompose.component.EventCard
import com.example.jetpackcompose.component.Title
import com.example.jetpackcompose.model.Event

@Composable
fun Home(navController: NavHostController) {
    val eventList = getSampleEvents()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Title(title = "Near you")
        }

        items(eventList) { event ->
            EventCard(event = event)
        }
    }
}

fun getSampleEvents(): List<Event> {
    return listOf(
        Event(
            contentId = 0,
            isTour = false,
            backgroundImageUrl = "https://cdn.albumoftheyear.org/artists/sq/nayt_1727482355.jpg",
            title = "Live@Atlantico",
            artistName = "Nayt",
            artistImageUrl = "https://nigga.gay/gayniggaskissing.png",
            description = "Atlantico - Roma",
            date = "2025/10/13"
        ),
        Event(
            contentId = 1,
            isTour = false,
            backgroundImageUrl = "https://cdn.albumoftheyear.org/artists/sq/nayt_1727482355.jpg",
            title = "Live@Atlantico",
            artistName = "Nayt",
            artistImageUrl = "https://nigga.gay/gayniggaskissing.png",
            description = "Atlantico - Roma",
            date = null
        ),
        Event(
            contentId = 1,
            isTour = false,
            backgroundImageUrl = "https://cdn.albumoftheyear.org/artists/sq/nayt_1727482355.jpg",
            title = "Live@Atlantico",
            artistName = "Nayt",
            artistImageUrl = "https://nigga.gay/gayniggaskissing.png",
            description = "Atlantico - Roma",
            date = null
        ),
        Event(
            contentId = 1,
            isTour = false,
            backgroundImageUrl = "https://cdn.albumoftheyear.org/artists/sq/nayt_1727482355.jpg",
            title = "Live@Atlantico",
            artistName = "Nayt",
            artistImageUrl = "https://nigga.gay/gayniggaskissing.png",
            description = "Atlantico - Roma",
            date = null
        ),
        Event(
            contentId = 1,
            isTour = false,
            backgroundImageUrl = "https://cdn.albumoftheyear.org/artists/sq/nayt_1727482355.jpg",
            title = "Live@Atlantico",
            artistName = "Nayt",
            artistImageUrl = "https://nigga.gay/gayniggaskissing.png",
            description = "Atlantico - Roma",
            date = null
        )

    )
}
