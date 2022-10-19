package com.lubnamariyam.tasklistingapp.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun TaskEditScreen(navController: NavController){
    Scaffold(
        topBar = {TopBar(title = "Edit", buttonText = "Save", onClick = {navController.navigate(route = "task_screen")})}, content = {
            Column(modifier = Modifier
                .background(color = Color.LightGray.copy(0.2f))
                .fillMaxSize()) {
                TaskEditCard()
            }
        }
    )
}
@Composable
fun TaskEditCard(){
    Card(elevation = 8.dp, shape = RoundedCornerShape(8.dp), modifier = Modifier
        .padding(20.dp)
        .fillMaxSize()
    ) {
        var text by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            }
        )
    }
}
