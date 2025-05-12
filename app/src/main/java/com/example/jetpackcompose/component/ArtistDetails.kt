package com.example.jetpackcompose.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.jetpackcompose.R
import com.example.jetpackcompose.model.Artist
import com.example.jetpackcompose.ui.theme.Secondary

@Composable
fun ArtistDetails(artist: Artist){
    Box {
        Box(
            modifier = Modifier
                .padding(start = 8.dp)
                .size(100.dp)
                .clip(CircleShape)
        ) {
            Image(
                painter = rememberAsyncImagePainter(artist.artistImageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop

            )
        }

        Column {
            Text(
                text = artist.artistName,
                color = Secondary,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                //modifier = Modifier.padding(horizontal = 8.dp)
            )

            Text(
                text = "${artist.likesCount} likes",
                color = Secondary,
                fontSize = 16.sp,
                //modifier = Modifier.padding(horizontal = 8.dp)
            )

            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "${artist.averageRating}",
                    color = Secondary,
                    fontSize = 16.sp,
                    //modifier = Modifier.padding(horizontal = 4.dp)
                )

                Icon(
                    ImageVector.vectorResource(R.drawable.favourites),
                    tint = Secondary,
                    contentDescription = null
                )
            }


        }
    }
}