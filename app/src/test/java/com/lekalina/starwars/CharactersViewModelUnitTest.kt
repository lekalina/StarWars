package com.lekalina.starwars

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.lekalina.starwars.data.model.Character
import com.lekalina.starwars.data.model.LiveDataCharacter
import com.lekalina.starwars.data.model.toLiveData
import com.lekalina.starwars.ui.characters.CharactersViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito.mock

@RunWith(MockitoJUnitRunner::class)
@OptIn(ExperimentalCoroutinesApi::class)
class CharactersViewModelUnitTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val vm = mock(CharactersViewModel::class.java)
    private val character = Character(name = "Luke Skywalker", hairColor = "Blonde")
    private val liveDataCharacter = character.toLiveData()
    private val characters = listOf(liveDataCharacter)

    @Test
    fun charactersTest() {
        runBlocking {
            val response: MutableLiveData<List<LiveDataCharacter>> = MutableLiveData(characters)
            Mockito.`when`(vm.characters).thenReturn(response)
            Assert.assertEquals(vm.characters.getOrAwaitValue().size, 1)
            Assert.assertEquals(vm.characters.getOrAwaitValue()[0].character.hairColor, "Blonde")
            Assert.assertEquals(vm.characters.getOrAwaitValue()[0].character.name, "Luke Skywalker")
        }
    }

    @Test
    fun scrollPositionTest() {
        runBlocking {
            val response: MutableLiveData<Int> = MutableLiveData(1)
            Mockito.`when`(vm.scrollPosition).thenReturn(response)
            Assert.assertEquals(vm.scrollPosition.getOrAwaitValue(), 1)
        }
    }

    @Test
    fun setFilmsTest() {
        runBlocking {
            val id = 1
            val response: LiveDataCharacter = liveDataCharacter
            Mockito.`when`(vm.setFilms(id)).thenReturn(response)
            Assert.assertEquals(vm.setFilms(id), liveDataCharacter)
        }
    }

    @Test
    fun setStarshipsTest() {
        runBlocking {
            val id = 1
            val response: LiveDataCharacter = liveDataCharacter
            Mockito.`when`(vm.setStarships(id)).thenReturn(response)
            Assert.assertEquals(vm.setStarships(id), liveDataCharacter)
        }
    }

    @Test
    fun setVehiclesTest() {
        runBlocking {
            val id = 1
            val response: LiveDataCharacter = liveDataCharacter
            Mockito.`when`(vm.setVehicles(id)).thenReturn(response)
            Assert.assertEquals(vm.setVehicles(id), liveDataCharacter)
        }
    }
}
