package com.example.jetpackcompose.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetpackcompose.ui.theme.Secondary

@Composable
fun Likes(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()){

        Column (
            modifier = Modifier.fillMaxSize().align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Likes", fontSize = 22.sp, color = Secondary)
        }


        //ArtistDetails(getSampleArtist().get(0), navController)
        //EventDetails(getSampleEvents().get(0), navController)
    }
}