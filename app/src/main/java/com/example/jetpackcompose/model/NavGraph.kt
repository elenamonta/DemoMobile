package com.example.jetpackcompose.model

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcompose.ui.view.Account
import com.example.jetpackcompose.ui.view.Home
import com.example.jetpackcompose.ui.view.Likes
import com.example.jetpackcompose.ui.view.Notification
import com.example.jetpackcompose.ui.view.Tickets

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
    }
}