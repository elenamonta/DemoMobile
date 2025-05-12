package com.example.jetpackcompose.model

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcompose.component.EventCard
import com.example.jetpackcompose.ui.screen.Account
import com.example.jetpackcompose.ui.screen.ArtistDetails
import com.example.jetpackcompose.ui.screen.ConcertMap
import com.example.jetpackcompose.ui.screen.EventDetails
import com.example.jetpackcompose.ui.screen.Home
import com.example.jetpackcompose.ui.screen.Likes
import com.example.jetpackcompose.ui.screen.Notification
import com.example.jetpackcompose.ui.screen.Tickets

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            Home(navController)
        }
        composable("likes") {
            Likes(navController)
        }
        composable("tickets") {
            Tickets(navController)
        }
        composable("account") {
            Account(navController)
        }
        composable("notifications") {
            Notification(navController)
        }
        composable("map") {
            ConcertMap(navController)
        }
        composable("eventDetails") { backStackEntry ->
            val event = backStackEntry
                .savedStateHandle
                .get<Event>("event")

            if (event != null) {
                EventDetails(event = event, navController = navController)
            } else {
                Text("Evento non disponibile")
            }
        }

        composable("artistDetails") { backStackEntry ->
            val artist = backStackEntry
                .savedStateHandle
                .get<Artist>("artist")

            if (artist != null) {
                ArtistDetails(artist = artist, navController = navController)
            } else {
                Text("Artista non disponibile")
            }
        }
    }
}