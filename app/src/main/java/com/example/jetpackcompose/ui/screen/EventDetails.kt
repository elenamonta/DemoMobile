package com.example.jetpackcompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.jetpackcompose.R
import com.example.jetpackcompose.component.MinimalArtist
import com.example.jetpackcompose.component.Title
import com.example.jetpackcompose.model.Event
import com.example.jetpackcompose.ui.theme.Bg_dark
import com.example.jetpackcompose.ui.theme.Fg_dark
import com.example.jetpackcompose.ui.theme.Primary
import com.example.jetpackcompose.ui.theme.Secondary
import com.example.jetpackcompose.ui.theme.rememberScreenDimensions

@Composable
fun EventDetails(event: Event, navController: NavController){
    val artistList = getSampleArtist()

    Column {
        Box{
            Box(
                modifier = Modifier
                    .size(rememberScreenDimensions().screenWidth, 150.dp)
            ){
                Image(
                    painter = rememberAsyncImagePainter(event.backgroundImageUrl),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Bottom

                ) {
                    Box (
                        modifier = Modifier
                            .background(Primary)
                    ){
                        Text(
                            text = event.title,
                            color = Secondary,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }

                    Box (
                        modifier = Modifier
                            .background(Fg_dark)
                    ){
                        Text(
                            text = event.description,
                            color = Color.White,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }
                }
            }

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

        Title("Artists")

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            items(artistList){ artist ->
                MinimalArtist(artist)
            }
        }
    }



}