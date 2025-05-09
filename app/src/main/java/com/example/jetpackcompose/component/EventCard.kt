package com.example.jetpackcompose.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.Fg_dark
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.jetpackcompose.model.Event
import com.example.jetpackcompose.ui.theme.Primary
import com.example.jetpackcompose.ui.theme.Secondary


@Composable
fun EventCard(event: Event){
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Card(
            modifier = Modifier
                .width(screenWidth * 0.9f)
                .height(200.dp),
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(3.dp, Fg_dark),
        ){
            Box{
                Image(
                    painter = rememberAsyncImagePainter(event.backgroundImageUrl),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                if (event.date != null) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(10.dp)
                            .background(Fg_dark)
                    ) {
                        Text(
                            text = event.date,
                            color = Color.White,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }
                }

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

                    Row (
                        modifier = Modifier
                            .background(Fg_dark),

                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Box(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .size(16.dp)
                                .clip(CircleShape)
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(event.artist.artistImageUrl),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()

                            )
                        }
                        Text(
                            text = event.artist.artistName,
                            fontSize = 12.sp,
                            color = Secondary,
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
        }
    }
}

