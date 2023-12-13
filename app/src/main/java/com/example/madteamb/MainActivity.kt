package com.example.madteamb

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RestrictTo
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.madteamb.NavigationItem.NavigationItem
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
                // A surface container using the 'background' color from the theme
                val items = listOf(
                    NavigationItem(
                        title = "All",
                        selectedIcon = Icons.Filled.Home,
                        unselectedIcon = Icons.Outlined.Home,
                    ),
                    NavigationItem(
                        title = "Urgent",
                        selectedIcon = Icons.Filled.Info,
                        unselectedIcon = Icons.Outlined.Info,
                        badgeCount = 45
                    ),
                    NavigationItem(
                        title = "Settings",
                        selectedIcon = Icons.Filled.Settings,
                        unselectedIcon = Icons.Outlined.Settings,
                    )


                )
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(16, 145, 33)),
                    color = MaterialTheme.colorScheme.background

                ) {
//                        mainScreen()
                    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                    val scope = rememberCoroutineScope()
                    var selectedItemIndex by rememberSaveable {
                        mutableStateOf(0)
                    }
                    ModalNavigationDrawer(
                            gesturesEnabled = drawerState.isOpen,

                            drawerContent = {
                                ModalDrawerSheet(
                                    drawerContainerColor = GreenBackGround,
                                ){
                                    items.forEachIndexed{ index, item ->

                                            NavigationDrawerItem(

                                                label = {
                                                    Text(text = item.title)
                                                },
                                                selected = index == selectedItemIndex,
                                                onClick = {
                                                    selectedItemIndex = index
                                                    scope.launch {
                                                        drawerState.close()
                                                    }
                                                },
                                                icon = {
                                                    Icon(
                                                        imageVector = if (index == selectedItemIndex) {
                                                            item.selectedIcon

                                                        } else item.unselectedIcon,
                                                        contentDescription = null
                                                    )
                                                },
                                                badge = {
                                                    item.badgeCount?.let {
                                                        Text(text = item.badgeCount.toString())

                                                    }

                                                }

                                            )
                                        }
                                    }


                                            },
                            drawerState = drawerState
                        ) {
                            Scaffold (
                                topBar = {
                                    TopAppBar(title = {
                                                },
                                     navigationIcon = {
                                        IconButton(onClick = {
                                            scope.launch {
                                                drawerState.open()
                                            }

                                            },
                                            modifier = Modifier.padding(10.dp)
                                        ) {
                                            Icon(imageVector = Icons.Default.Menu, contentDescription= "Menu",
                                                        tint = Color.White, modifier = Modifier.size(40.dp)
                                            )

                                            }
                                             },
                                        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = GreenBackGround )

                                        )
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

