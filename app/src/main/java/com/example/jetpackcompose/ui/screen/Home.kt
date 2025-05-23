package com.example.jetpackcompose.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.jetpackcompose.R
import com.example.jetpackcompose.component.EventCard
import com.example.jetpackcompose.component.SimpleSearchBar
import com.example.jetpackcompose.component.Title
import com.example.jetpackcompose.model.Artist
import com.example.jetpackcompose.model.Event
import com.example.jetpackcompose.ui.theme.Fg_dark
import com.example.jetpackcompose.ui.theme.Primary
import com.example.jetpackcompose.ui.theme.Secondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController) {
    val eventList = getSampleEvents()

    var query by rememberSaveable { mutableStateOf("") }
    val onQueryChange: (String) -> Unit = { query = it }

    Column (
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleSearchBar(
            query = query,
            onQueryChange = onQueryChange,
            searchResultsArtists = getSampleArtist(),
            searchResultsEvents = getSampleEvents(),
            navController = navController
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Title(title = "Near you")
            }

            item {
                ButtonWithIcons(ImageVector.vectorResource(R.drawable.map), "Open map", ImageVector.vectorResource(R.drawable.arrow), navController)
            }

            items(eventList) { event ->
                EventCard(event = event, navController)
            }
        }
    }
}


fun onClick(navController: NavHostController) {
    navController.navigate("map"){
        popUpTo(navController.graph.startDestinationId) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun getSampleEvents(): List<Event> {
    return listOf(
        Event(
            contentId = 0,
            isTour = true,
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

@Composable
fun ButtonWithIcons(startIcon: ImageVector?, textBtn: String, endIcon: ImageVector?, navController: NavHostController){
    Button(
        onClick = { onClick(navController) },
        colors = ButtonColors(
            containerColor = Primary,
            contentColor = Primary,
            disabledContentColor = Color.Transparent,
            disabledContainerColor = Color.Transparent
        ),
        modifier = Modifier
            .padding(vertical = 8.dp)
    ) {
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            if (startIcon != null) {
                Icon(
                    imageVector = startIcon,
                    contentDescription = null,
                    tint = Fg_dark,
                )
            }
            Text(
                text = textBtn,
                fontSize = 16.sp,
                color = Fg_dark,
                modifier = Modifier.padding(horizontal = 8.dp),
                fontWeight = FontWeight.Bold
            )
            if (endIcon != null) {
                Icon(
                    imageVector = endIcon,
                    contentDescription = null,
                    tint = Fg_dark
                )
            }
        }
    }
}