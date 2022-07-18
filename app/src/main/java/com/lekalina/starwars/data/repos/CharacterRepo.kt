package com.lekalina.starwars.data.repos

import com.lekalina.starwars.data.api.StarWarsApi
import com.lekalina.starwars.data.helpers.handleRequest
import javax.inject.Inject

class CharacterRepo @Inject constructor(
    private val api: StarWarsApi
) {
    suspend fun getCharacters(page: Int) = handleRequest { api.getCharacters(page) }
    suspend fun getHomeworld(id: Int) = handleRequest { api.getHomeworld(id) }
    suspend fun getFilm(id: Int) = handleRequest { api.getFilm(id) }
    suspend fun getStarship(id: Int) = handleRequest { api.getStarship(id) }
    suspend fun getVehicle(id: Int) = handleRequest { api.getVehicle(id) }
}
