package com.lekalina.starwars.ui.navigation

sealed class NavRoutes(
    val route: String
) {
    object Characters : NavRoutes("characters")
    object CharacterBio : NavRoutes("bio")
    object Films : NavRoutes("films")
    object Starships : NavRoutes("starships")
    object Vehicles : NavRoutes("vehicles")
}

object RouteExtra {
    const val CHARACTER_ID = "character_id"
    const val FILM_IDS = "film_ids"
    const val STARSHIP_IDS = "starship_ids"
    const val VEHICLE_IDS = "vehicle_ids"
}
