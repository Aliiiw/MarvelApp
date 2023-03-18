package com.example.mymarvelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mymarvelapp.data.Screen
import com.example.mymarvelapp.ui.theme.MyMarvelAppTheme
import com.example.mymarvelapp.view.screens.CharactersBottomNavigation
import com.example.mymarvelapp.view.screens.CollectionScreen
import com.example.mymarvelapp.view.screens.LibraryScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMarvelAppTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    CharactersScaffold(navController = navController)
                }
            }
        }
    }
}


@Composable
fun CharactersScaffold(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {},

        bottomBar = {
            CharactersBottomNavigation(navController = navController)
        }
    ) { paddingValues ->

        NavHost(navController = navController, startDestination = Screen.Library.route) {
            composable(Screen.Library.route) {
                LibraryScreen()
            }

            composable(Screen.Collection.route) {
                CollectionScreen()
            }

            composable(Screen.CharacterDetail.route) { navBackStackEntry ->

            }
        }

    }
}