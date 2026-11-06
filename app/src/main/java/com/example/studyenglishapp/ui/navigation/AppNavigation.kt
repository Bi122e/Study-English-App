package com.example.studyenglishapp.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Style
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.MenuBook
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

data class BottomNavItem(

    val title: String,
    val route: String,
    val icon: ImageVector
)

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val items = listOf(
        BottomNavItem(
            title = "Home",
            route = "home",
            icon = Icons.Rounded.MenuBook
        ),
        BottomNavItem(
            title = "Vocabulary",
            route = "vocabulary",
            icon = Icons.Rounded.MenuBook
        ),
        BottomNavItem(
            title = "Flashcard",
            route = "flashCard",
            icon = Icons.Default.Style
        ),
    )

    Scaffold(
        bottomBar = {

            NavigationBar {

                val currentRoute = navController.currentBackStackEntryAsState()
                    .value?.destination?.route

                items.forEach { item ->

                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(
                                    navController.graph.findStartDestination().id
                                ) {
                                    saveState = true
                                }

                                launchSingleTop = true
                                restoreState = true
                            }
                        },

                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.title
                            )
                        },
                        label = {
                            Text(item.title)
                        }
                    )
                }
            }
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues
            )
        ) {

            composable(route = "home") {
                HomeScreen()
            }

             composable(route = "vocabulary") {
                VocabularyScreen()
            }

             composable(route = "home") {
                ProfileScreen()
            }



        }
    }
}