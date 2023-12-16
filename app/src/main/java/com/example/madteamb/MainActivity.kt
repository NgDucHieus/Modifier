package com.example.madteamb

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.madteamb.NavigationItem.AppBar2
import com.example.madteamb.NavigationItem.DrawerBody
import com.example.madteamb.NavigationItem.DrawerHeader
import com.example.madteamb.NavigationItem.MenuItem
import com.example.madteamb.model.Timer.TimerViewModel
import com.example.madteamb.ui.theme.Coin.Coin
import com.example.madteamb.ui.theme.GreenBackGround
import com.example.madteamb.ui.theme.MadTeamBTheme
import com.example.madteamb.ui.theme.mainScreen
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MadTeamBTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(16, 145, 33)),
                    color = MaterialTheme.colorScheme.background

                ) {
                    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                    val scope = rememberCoroutineScope()
                    ModalNavigationDrawer(
                            gesturesEnabled = drawerState.isOpen,


                            drawerContent = {
                                ModalDrawerSheet(
                                    drawerContainerColor = GreenBackGround,
                                ){
                                    DrawerHeader()
                                    DrawerBody(
                                        items = listOf(
                                            MenuItem(id = "home",
                                                    title = "Home",
                                                    contentDiscription = "Go to Home",
                                                    icon = Icons.Default.Home
                                                ),
                                            MenuItem(id = "Settings",
                                                    title = "Settings",
                                                    contentDiscription = "Go to Settings",
                                                    icon =Icons.Default.Settings



                                                ),
                                            MenuItem(id = "Shop",
                                                    title = "Shop",
                                                    contentDiscription = "Go to Shop",
                                                    icon = Icons.Default.ShoppingCart

                                            )

                                        ),
                                        onItemClick = {

                                            println("Click on ${it.title}")
                                        },
                                        modifier = Modifier

                                    )
                                    }
                                            },
                            drawerState = drawerState
                        ) {
                            Scaffold (
                                topBar = {
//                                    Text(text = "Helo World")
//                                    AppBar(onNavigationIconClick = {scope.launch { drawerState.open() }})
                                    AppBar2 (onNavigationIconClick = {scope.launch { drawerState.open() }})

                                }
                            ){
                                mainScreen()
                            }
                        
                    }
                }

            }
        }
    }
}




