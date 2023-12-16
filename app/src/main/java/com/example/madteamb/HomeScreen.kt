package com.example.madteamb

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen()
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "First_Screen")
    {
        composable("First_Screen")
        {
            Screen1(navController = navController)
        }
        composable("Second_Screen")
        {
            Screen2(navController =navController)
        }
    }

}
@Composable
fun Screen1(navController: NavController)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()

    ) {
            Text(text = "This is screen 1",
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
        )
        Button(onClick = {
                navController.navigate("Second_Screen")
        }) {
            Text(text = "Change Screen")
        }

    }
}
@Composable
fun Screen2(navController: NavController)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()

    ) {
        Text(text = "This is screen 2",
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp
        )
        Button(onClick = {
                navController.popBackStack()
        }) {
            Text(text = "Change Screen")
        }

    }
}
@Preview
@Composable
fun Precnav()
{

    HomeScreen()
}