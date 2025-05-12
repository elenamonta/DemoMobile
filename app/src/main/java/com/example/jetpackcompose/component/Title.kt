package com.example.jetpackcompose.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.Secondary

@Composable
fun Title(title: String){
    var textWidth by remember { mutableStateOf(0) }

    Column (
        modifier = Modifier
            .fillMaxSize(),
            //.padding(top=8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = title,
            color = Secondary,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
//            modifier = Modifier.onGloballyPositioned { coordinates ->
//                textWidth = coordinates.size.width
//            }
        )
        HorizontalDivider(
            modifier = Modifier
                .padding(top = 8.dp)
                .width(180.dp),
                //.width(with(LocalDensity.current) { (textWidth + 40).toDp() }),
            thickness = 1.dp,
            color = Secondary
        )
    }
}