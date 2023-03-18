package com.example.mymarvelapp.view.screens

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mymarvelapp.R
import com.example.mymarvelapp.data.Screen

@Composable
fun CharactersBottomNavigation(navController: NavHostController) {
    BottomNavigation(elevation = 5.dp) {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry.value?.destination

        val iconLibrary = painterResource(id = R.drawable.ic_library)
        val iconCollection = painterResource(id = R.drawable.ic_collection)


        BottomNavigationItem(
            selected = currentDestination?.route == Screen.Library.route,
            onClick = {
                navController.navigate(Screen.Library.route) {
                    popUpTo(Screen.Library.route)
                    launchSingleTop = true
                }
            },
            icon = {
                Icon(painter = iconLibrary, contentDescription = "")
            },
            label = {
                Text(text = Screen.Library.route)
            }
        )

        BottomNavigationItem(
            selected = currentDestination?.route == Screen.Collection.route,
            onClick = {
                navController.navigate(Screen.Collection.route) {
                    launchSingleTop = true
                }
            },
            icon = {
                Icon(painter = iconCollection, contentDescription = "")
            },
            label = {
                Text(text = Screen.Collection.route)
            }
        )
    }
}