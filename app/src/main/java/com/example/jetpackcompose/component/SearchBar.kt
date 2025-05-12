package com.example.jetpackcompose.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.material3.Divider
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.jetpackcompose.R
import com.example.jetpackcompose.model.Artist
import com.example.jetpackcompose.model.Event
import com.example.jetpackcompose.ui.theme.Bg_dark
import com.example.jetpackcompose.ui.theme.Fg_dark
import com.example.jetpackcompose.ui.theme.Secondary
import com.example.jetpackcompose.ui.theme.rememberScreenDimensions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    searchResultsArtists: List<Artist>,
    searchResultsEvents: List<Event>,
    colors: SearchBarColors = SearchBarDefaults.colors(
        containerColor = Fg_dark,
        dividerColor = Color.Transparent,
        inputFieldColors = TextFieldDefaults.colors(Secondary.copy(alpha = 0.5f))
    ),
    shape: Shape = RoundedCornerShape(30.dp),
    navController: NavHostController
){

    var expanded by rememberSaveable { mutableStateOf(false) }

    val filteredArtists = remember(query, searchResultsArtists) {
        searchResultsArtists.filter { it.artistName.contains(query, ignoreCase = true) }
    }

    val filteredEvents = remember(query, searchResultsEvents) {
        searchResultsEvents.filter { it.title.contains(query, ignoreCase = true) }
    }


    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBar(
            query = query,
            onQueryChange = {
                onQueryChange(it)
                expanded = it.isNotBlank()
            },
            onSearch = { expanded = false },
            active = expanded,
            onActiveChange = { expanded = it },
            placeholder = {
                Text(
                    text = "Search your wave...",
                    color = Secondary.copy(alpha = 0.5f)
                ) },
            leadingIcon = {
                Icon(
                    ImageVector.vectorResource(R.drawable.search),
                    tint = Secondary,
                    contentDescription = null
                )
            },
            colors = colors,
            shape = shape,
            modifier = Modifier
                .width(rememberScreenDimensions().screenWidth * 0.9f)
        ) {
            if(expanded){
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    if(filteredArtists.isNotEmpty()){
                        items(filteredArtists){ artist ->
                                MinimalArtist(artist)
                        }
                    }

                }

                HorizontalDivider(
                    modifier = Modifier
                        .width(rememberScreenDimensions().screenWidth * 0.85f)
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp),
                    thickness = 1.dp,
                    color = Secondary.copy(alpha = 0.5f),

                )

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (filteredEvents.isNotEmpty()) {
                        items(filteredEvents) { event ->
                            EventCard(event = event, navController)
                        }
                    }
                }
            }

        }
    }
}


@Composable
fun MinimalArtist(artist: Artist){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Box(
            modifier = Modifier
                .padding(4.dp)
                .size(50.dp)
                .clip(CircleShape)
        ) {
            Image(
                painter = rememberAsyncImagePainter(artist.artistImageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()

            )
        }
        Text(
            text = artist.artistName,
            fontSize = 16.sp,
            color = Secondary,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

    }
}