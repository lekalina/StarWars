package com.lekalina.starwars.data.api

import com.lekalina.starwars.data.model.Character
import com.lekalina.starwars.data.model.Characters
import com.lekalina.starwars.data.model.Film
import com.lekalina.starwars.data.model.Planet
import com.lekalina.starwars.data.model.Starship
import com.lekalina.starwars.data.model.Vehicle
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

@Suppress("unused")
interface StarWarsApi {

    @GET("people/")
    suspend fun getCharacters(
        @Query("page") page: Int
    ): Characters

    @GET("planets/{id}")
    suspend fun getHomeworld(@Path("id") id: Int): Planet

    @GET("people/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Character

    @GET("films/{id}")
    suspend fun getFilm(@Path("id") id: Int): Film

    @GET("starships/{id}")
    suspend fun getStarship(@Path("id") id: Int): Starship

    @GET("vehicles/{id}")
    suspend fun getVehicle(@Path("id") id: Int): Vehicle
}
