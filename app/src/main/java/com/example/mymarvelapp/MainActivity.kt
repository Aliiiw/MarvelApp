package com.example.mymarvelapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mymarvelapp.data.Screen
import com.example.mymarvelapp.ui.theme.MyMarvelAppTheme
import com.example.mymarvelapp.view.screens.CharacterDetailScreen
import com.example.mymarvelapp.view.screens.CharactersBottomNavigation
import com.example.mymarvelapp.view.screens.CollectionScreen
import com.example.mymarvelapp.view.screens.LibraryScreen
import com.example.mymarvelapp.viewmodel.CollectionDbViewModel
import com.example.mymarvelapp.viewmodel.LibraryApiViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val libraryViewModel by viewModels<LibraryApiViewModel>()
    private val collectionViewModel by viewModels<CollectionDbViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMarvelAppTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    CharactersScaffold(
                        navController = navController,
                        libraryViewModel = libraryViewModel,
                        collectionDbViewModel = collectionViewModel
                    )
                }
            }
        }
    }
}


@Composable
fun CharactersScaffold(
    navController: NavHostController,
    libraryViewModel: LibraryApiViewModel,
    collectionDbViewModel: CollectionDbViewModel
) {
    val scaffoldState = rememberScaffoldState()
    val context = LocalContext.current

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {},

        bottomBar = {
            CharactersBottomNavigation(navController = navController)
        }
    ) { paddingValues ->

        NavHost(navController = navController, startDestination = Screen.Library.route) {
            composable(Screen.Library.route) {
                LibraryScreen(
                    navController = navController,
                    vm = libraryViewModel,
                    paddingValues = paddingValues
                )
            }

            composable(Screen.Collection.route) {
                CollectionScreen(cvm = collectionDbViewModel, navController = navController)
            }

            composable(Screen.CharacterDetail.route) { navBackStackEntry ->
                val id = navBackStackEntry.arguments?.getString("characterId")?.toIntOrNull()

                if (id == null) Toast.makeText(
                    context,
                    "Character id is required",
                    Toast.LENGTH_SHORT
                ).show()
                else {
                    libraryViewModel.retrieveSingleCharacter(id)

                    CharacterDetailScreen(
                        lvm = libraryViewModel,
                        cvm = collectionDbViewModel,
                        paddingValues = paddingValues,
                        navController = navController
                    )
                }
            }
        }
    }
}