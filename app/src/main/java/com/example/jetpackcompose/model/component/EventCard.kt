package com.example.jetpackcompose.model.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.theme.Primary
import coil.compose.rememberImagePainter


@Composable
fun EventCard(content_id: Int, isTour: Boolean, backgroundImageUrl: String, title: String, artistName: String, artistImageUrl: String, description: String, date: String?){
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    
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
                    painter = rememberAsyncImagePainter(backgroundImageUrl),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Bottom

                ) {
                    Box (
                        modifier = Modifier
                            .background(Primary)
                            .padding(5.dp)
                    ){
                        Text(
                            text = title,
                            color = Color.White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                            //style = MaterialTheme.typography.titleLarge
                        )
                    }
                    Row (
                        modifier = Modifier
                            .background(Fg_dark)
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Box(
                            modifier = Modifier
                                .size(16.dp)
                                .clip(CircleShape)
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(artistImageUrl),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Text(
                            text = artistName,
                            fontSize = 12.sp,
                            color = Color.White
                        )

                    }

                    Box (
                        modifier = Modifier
                            .background(Fg_dark)
                            .padding(5.dp)
                    ){
                        Text(
                            text = description,
                            color = Color.White,
                            fontSize = 12.sp,
                            //style = MaterialTheme.typography.titleLarge
                        )
                    }

                }
            }
        }
    }
}