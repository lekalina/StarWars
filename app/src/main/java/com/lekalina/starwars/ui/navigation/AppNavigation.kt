package com.lekalina.starwars.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.lekalina.starwars.ui.characters.CharactersViewModel
import com.lekalina.starwars.ui.characters.CharactersScreen
import com.lekalina.starwars.ui.characters.FilmsScreen
import com.lekalina.starwars.ui.characters.CharacterBioScreen
import com.lekalina.starwars.ui.characters.VehiclesScreen
import com.lekalina.starwars.ui.characters.StarshipsScreen

@Composable
fun AppNavHost(
    navViewModel: NavigationViewModel
) {
    val charactersVM = hiltViewModel<CharactersViewModel>()
    NavHost(navController = navViewModel.navController, startDestination = navViewModel.startingRoute.route) {
        composable(NavRoutes.Characters.route) {
            CharactersScreen(charsVM = charactersVM, navVM = navViewModel)
        }
        composable(NavRoutes.CharacterBio.route
            .plus("/{${RouteExtra.CHARACTER_ID}}"),
            arguments = listOf(navArgument(RouteExtra.CHARACTER_ID) {
                type = NavType.IntType
            })
        ) {
            it.arguments?.getInt(RouteExtra.CHARACTER_ID)?.let { id ->
                CharacterBioScreen(navVM = navViewModel, charsVM = charactersVM, characterId = id)
            }
        }
        composable(NavRoutes.Films.route
            .plus("/{${RouteExtra.CHARACTER_ID}}"),
            arguments = listOf(navArgument(RouteExtra.CHARACTER_ID) {
                type = NavType.IntType
            })
        ) {
            it.arguments?.getInt(RouteExtra.CHARACTER_ID)?.let { id ->
                FilmsScreen(charsVM = charactersVM, characterId = id)
            }
        }
        composable(NavRoutes.Starships.route
            .plus("/{${RouteExtra.CHARACTER_ID}}"),
            arguments = listOf(navArgument(RouteExtra.CHARACTER_ID) {
                type = NavType.IntType
            })
        ) {
            it.arguments?.getInt(RouteExtra.CHARACTER_ID)?.let { id ->
                StarshipsScreen(charsVM = charactersVM, characterId = id)
            }
        }
        composable(NavRoutes.Vehicles.route
            .plus("/{${RouteExtra.CHARACTER_ID}}"),
            arguments = listOf(navArgument(RouteExtra.CHARACTER_ID) {
                type = NavType.IntType
            })
        ) {
            it.arguments?.getInt(RouteExtra.CHARACTER_ID)?.let { id ->
                VehiclesScreen(charsVM = charactersVM, characterId = id)
            }
        }
    }
}
