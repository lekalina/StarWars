package com.lekalina.starwars.ui.navigation

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

class NavigationViewModel(
    val navController: NavHostController
) : ViewModel() {

    val startingRoute = NavRoutes.Characters

    fun back() {
        navController.popBackStack()
    }

    fun navigate(route: String) {
        navController.navigate(route)
    }

    fun navigate(
        route: String,
        argumentValue: Any
    ) {
        navController.navigate(route.plus("/$argumentValue"))
    }
}
