package com.example.jetpackcompose.ui.view

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
import com.example.jetpackcompose.R
import com.example.jetpackcompose.model.component.EventCard
import com.example.jetpackcompose.ui.theme.Secondary

@Composable
fun Home(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()){
        Column (
            modifier = Modifier.fillMaxSize().align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EventCard(
                content_id = 0,
                isTour = false,
                backgroundImageUrl = "file:///storage/emulated/0/hitwaves_prova/background.jpg",
                title = "Live@Atlantico",
                artistName = "Nayt",
                artistImageUrl = "file:///storage/emulated/0/hitwaves_prova/background.jpg",
                description = "Atlantico - Roma",
                date = null
            )
        }
    }
}