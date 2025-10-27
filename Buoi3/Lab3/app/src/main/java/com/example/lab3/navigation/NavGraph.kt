package com.example.lab3.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab3.ui.screens.CompontentsList

// Định nghĩa các màn hình
sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object ComponentsList : Screen("components_list")
    object TextDetail : Screen("text_detail")
    object ImagesDetail : Screen("images_detail")
    object TextFieldDetail : Screen("textfield_detail")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Welcome.route) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(
                onReadyClick = {
                    navController.navigate(Screen.ComponentsList.route)
                }
            )
        }

        composable(Screen.ComponentsList.route) {
            ComponentsList(
                onTextClick = { navController.navigate(Screen.TextDetail.route) },
                onImageClick = { navController.navigate(Screen.ImagesDetail.route) },
                onTextFieldClick = { navController.navigate(Screen.TextFieldDetail.route) },
                onBackClick = { navController.navigateUp() }
            )
        }

        composable(Screen.TextDetail.route) {
            TextDetailScreen(
                onBackClick = { navController.navigateUp() }
            )
        }

        composable(Screen.ImagesDetail.route) {
            ImagesDetailScreen(
                onBackClick = { navController.navigateUp() }
            )
        }

        composable(Screen.TextFieldDetail.route) {
            TextFieldDetailScreen(
                onBackClick = { navController.navigateUp() }
            )
        }
    }
}