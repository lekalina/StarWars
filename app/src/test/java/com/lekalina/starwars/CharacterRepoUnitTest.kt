package com.lekalina.starwars

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.lekalina.starwars.data.api.StarWarsApi
import com.lekalina.starwars.data.helpers.API_FIRST_PAGE
import com.lekalina.starwars.data.model.Character
import com.lekalina.starwars.data.model.Characters
import com.lekalina.starwars.data.model.Film
import com.lekalina.starwars.data.model.Planet
import com.lekalina.starwars.data.model.Starship
import com.lekalina.starwars.data.model.Vehicle
import com.lekalina.starwars.data.repos.CharacterRepo
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito.mock

@RunWith(MockitoJUnitRunner::class)
class CharacterRepoUnitTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val api = mock(StarWarsApi::class.java)
    private val repo = CharacterRepo(api)

    @Test
    fun getCharactersTest() {
        val character = Character(name = "Luke Skywalker", hairColor = "Blonde")
        val characters = Characters(
            count = 1, next = null, previous = null, results = listOf(character)
        )
        runBlocking {
            Mockito.`when`(api.getCharacters(API_FIRST_PAGE)).thenReturn(characters)
            val response = repo.getCharacters(API_FIRST_PAGE)
            Assert.assertEquals(response?.results?.size ?: 0, 1)
        }
    }

    @Test
    fun getHomeworldTest() {
        val planet = Planet(name = "Tatooine")
        runBlocking {
            val id = 1
            Mockito.`when`(api.getHomeworld(id)).thenReturn(planet)
            val response = repo.getHomeworld(id)
            Assert.assertEquals(response?.name, "Tatooine")
        }
    }

    @Test
    fun getFilmTest() {
        val film = Film(episodeId = 4)
        runBlocking {
            val id = 1
            Mockito.`when`(api.getFilm(id)).thenReturn(film)
            val response = repo.getFilm(id)
            Assert.assertEquals(response?.episodeId, 4)
        }
    }

    @Test
    fun getStarshipTest() {
        val starship = Starship(name = "TIE Fighter")
        runBlocking {
            val id = 1
            Mockito.`when`(api.getStarship(id)).thenReturn(starship)
            val response = repo.getStarship(id)
            Assert.assertEquals(response?.name, "TIE Fighter")
        }
    }

    @Test
    fun getVehicleTest() {
        val vehicle = Vehicle(name = "Land Speeder")
        runBlocking {
            val id = 1
            Mockito.`when`(api.getVehicle(id)).thenReturn(vehicle)
            val response = repo.getVehicle(id)
            Assert.assertEquals(response?.name, "Land Speeder")
        }
    }
}
