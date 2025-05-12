package com.example.jetpackcompose.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackcompose.R
import com.example.jetpackcompose.component.ArtistCard
import com.example.jetpackcompose.component.EventCard
import com.example.jetpackcompose.component.Title
import com.example.jetpackcompose.model.Artist
import com.example.jetpackcompose.ui.theme.Bg_dark
import com.example.jetpackcompose.ui.theme.Primary
import com.example.jetpackcompose.ui.theme.Secondary

@Composable
fun ArtistDetails(artist: Artist, navController: NavController){
    val eventList = getSampleEvents()

    BackToHome(navController)

    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier
                .padding(top = 30.dp)
        ){
            ArtistCard(getSampleArtist().get(0))
        }

        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item{
                Title("Next Event")
            }

            items(eventList) { event ->
                EventCard(event = event, navController)
            }
        }
    }
}

@Composable
fun BackToHome(navController: NavController){
    Box(
        modifier = Modifier
            .size(35.dp)
            .clip(CircleShape)
            .background(Primary)
            .clickable { navController.navigateUp() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.back),
            contentDescription = null,
            tint = Bg_dark
        )
    }
}