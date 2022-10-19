package com.lubnamariyam.tasklistingapp.ui.view

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lubnamariyam.tasklistingapp.R
import com.lubnamariyam.tasklistingapp.ui.theme.TaskListingAppTheme

@Composable
fun TaskListScreen(navController: NavController){
    Scaffold(
        topBar = {TopBar(title = "Daily Tasks", buttonText = "Clear All", onClick = {})}, content = {
        //TaskListEmpty()
            Column(modifier = Modifier
                .background(color = Color.LightGray.copy(0.2f))
                .fillMaxSize()) {
                TaskListCard()
            }
    }, floatingActionButton = {
        ExtendedFloatingActionButton(onClick = {navController.navigate(route = "task_edit_screen")} , shape = RoundedCornerShape(8.dp), backgroundColor = Color.White,
        text = {Text(text = "Add Task",modifier = Modifier.padding(10.dp))}, icon = {Icon(imageVector = Icons.Default.Add, contentDescription ="",modifier = Modifier.padding(end = 10.dp) )
        })
    })
}

@Composable
fun TaskListEmpty(){
        Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()){
            Image(painter = painterResource(id = R.drawable.tasklist), contentDescription ="empty list" , alignment = Alignment.Center)
        }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TaskListCard(){
    Card(elevation = 8.dp, shape = RoundedCornerShape(8.dp), modifier = Modifier
        .padding(20.dp)
        .clickable { }) {
        ListItem(
            text = { Text(text = "Add your task's") },
            trailing = {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.Delete,
                        contentDescription = null
                    )
                }
            }
        )
    }
}


@Composable
fun TopBar(title:String,buttonText:String,onClick:() -> Unit){
    TopAppBar(title ={ Text(text = title)},
        actions = {
            val gradientGrayWhite = Brush.verticalGradient(0f to Color.Blue, 1000f to Color.Yellow)
            Button(onClick = { onClick() }, modifier =Modifier.padding(10.dp), border = BorderStroke(1.dp, brush = gradientGrayWhite) , content = {
                      Row(verticalAlignment = Alignment.CenterVertically) {
                          //Icon(painter = painterResource(id = R.drawable.ic_baseline_delete_24), contentDescription = "delete all", modifier = Modifier.padding(10.dp), tint = Color.Black)
                          Text(text = buttonText)
                      }
                  })
                  },
        /*navigationIcon = {Icon(
        painter = painterResource(id = R.drawable.ic_baseline_menu_book_24),
        contentDescription = "menu",modifier = Modifier
                .padding(10.dp)
                .size(32.dp)
    )}*/
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskListingAppTheme {
        //TaskListScreen()
    }
}