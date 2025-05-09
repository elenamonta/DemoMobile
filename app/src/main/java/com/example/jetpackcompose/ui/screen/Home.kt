package com.example.jetpackcompose.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.jetpackcompose.component.EventCard
import com.example.jetpackcompose.component.SimpleSearchBar
import com.example.jetpackcompose.component.Title
import com.example.jetpackcompose.model.Artist
import com.example.jetpackcompose.model.Event

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController) {
    val eventList = getSampleEvents()

    var query by rememberSaveable { mutableStateOf("") }
    val onQueryChange: (String) -> Unit = { query = it }

    // Funzioni per la gestione del click
    val onArtistClick: (Artist) -> Unit = { artist ->
        println("Artista selezionato: ${artist.artistName}")
    }

    val onEventClick: (Event) -> Unit = { event ->
        println("Evento selezionato: ${event.title}")
    }


    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleSearchBar(
            query = query,
            onQueryChange = onQueryChange,
            searchResultsArtists = getSampleArtist(),
            searchResultsEvents = getSampleEvents(),
            onArtistClick = onArtistClick,
            onEventClick = onEventClick
        )

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


}



fun getSampleEvents(): List<Event> {
    return listOf(
        Event(
            contentId = 0,
            isTour = false,
            backgroundImageUrl = "https://cdn.albumoftheyear.org/artists/sq/nayt_1727482355.jpg",
            title = "Live@Roma",
            artist = Artist(
                artistId = 0,
                artistName = "Nayt",
                artistImageUrl = "https://nigga.gay/gayniggaskissing.png",
                likesCount = 4800,
                averageRating = 4.8f
            ),

            description = "Atlantico - Roma",
            date = "2025/10/13"
        ),
        Event(
            contentId = 0,
            isTour = false,
            backgroundImageUrl = "https://cdn.albumoftheyear.org/artists/sq/nayt_1727482355.jpg",
            title = "Live@Bologna",
            artist = Artist(
                artistId = 0,
                artistName = "Nayt",
                artistImageUrl = "https://nigga.gay/gayniggaskissing.png",
                likesCount = 4800,
                averageRating = 4.8f
            ),

            description = "Atlantico - Roma",
            date = "2025/10/13"
        ),
        Event(
            contentId = 0,
            isTour = false,
            backgroundImageUrl = "https://cdn.albumoftheyear.org/artists/sq/nayt_1727482355.jpg",
            title = "Live@Chicago",
            artist = Artist(
                artistId = 0,
                artistName = "Nayt",
                artistImageUrl = "https://nigga.gay/gayniggaskissing.png",
                likesCount = 4800,
                averageRating = 4.8f
            ),

            description = "Atlantico - Roma",
            date = "2025/10/13"
        ),
        Event(
            contentId = 0,
            isTour = false,
            backgroundImageUrl = "https://cdn.albumoftheyear.org/artists/sq/nayt_1727482355.jpg",
            title = "Live@Nonantola",
            artist = Artist(
                artistId = 0,
                artistName = "Nayt",
                artistImageUrl = "https://nigga.gay/gayniggaskissing.png",
                likesCount = 4800,
                averageRating = 4.8f
            ),

            description = "Atlantico - Roma",
            date = "2025/10/13"
        )

    )
}

fun getSampleArtist(): List<Artist>{
    return listOf(
        Artist(
            artistId = 0,
            artistName = "Nayt",
            artistImageUrl = "https://nigga.gay/gayniggaskissing.png",
            likesCount = 4800,
            averageRating = 4.8f
        ),
        Artist(
            artistId = 0,
            artistName = "RosoloRoso",
            artistImageUrl = "https://nigga.gay/gayniggaskissing.png",
            likesCount = 4800,
            averageRating = 4.8f
        ),
        Artist(
            artistId = 0,
            artistName = "Sfera",
            artistImageUrl = "https://nigga.gay/gayniggaskissing.png",
            likesCount = 4800,
            averageRating = 4.8f
        ),
        Artist(
            artistId = 0,
            artistName = "Izi",
            artistImageUrl = "https://nigga.gay/gayniggaskissing.png",
            likesCount = 4800,
            averageRating = 4.8f
        )
    )
}