package com.jasper.composenoteapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesListScreen(navigateToNoteInputScreen: () -> Unit) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.shadow(elevation = 7.dp),
                title = {
                    Text(
                        text = "Notes",
                        fontSize = 14.sp,
                        color = Black
                    )
                },
                actions = {
                    Button(
                        onClick = {
                            navigateToNoteInputScreen()
                        }
                    ) {
                        Text(text = "Add note")
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = null,
                            modifier = Modifier.size(30.dp),
                            tint = White
                        )
                    }

                }
            )
        }
    )
    { scaffoldPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(scaffoldPadding),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(4) {
                NoteCardItem()
            }
        }
    }
}

@Composable
fun NoteCardItem() {

    Card(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(150.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = White)
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(20.dp), contentAlignment = Alignment.TopStart
        ) {
            Text(
                text = "",
                color = White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Black
            )
        }
    }
}