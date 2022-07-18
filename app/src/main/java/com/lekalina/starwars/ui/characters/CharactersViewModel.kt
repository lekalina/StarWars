package com.lekalina.starwars.ui.characters

import androidx.compose.foundation.lazy.LazyListState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lekalina.starwars.data.helpers.CHARACTERS
import com.lekalina.starwars.data.helpers.FILMS
import com.lekalina.starwars.data.helpers.STARSHIPS
import com.lekalina.starwars.data.helpers.VEHICLES
import com.lekalina.starwars.data.helpers.parseId
import com.lekalina.starwars.data.model.Film
import com.lekalina.starwars.data.model.LiveDataCharacter
import com.lekalina.starwars.data.model.Starship
import com.lekalina.starwars.data.model.Vehicle
import com.lekalina.starwars.domain.usecase.CharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val useCase: CharacterUseCase
) : ViewModel() {

    val scrollState = LazyListState()
    val scrollPosition = MutableLiveData(0)
    private val mScrollPosition: LiveData<Int> = scrollPosition
    private val pager = useCase.characterPager(viewModelScope, mScrollPosition)
    val characters: LiveData<List<LiveDataCharacter>> = pager.characters

    /**
     * Pulls the LiveDataCharacter from existing list of characters
     * by character id or returns null
     */
    fun getCharacter(id: Int): LiveDataCharacter? {
        return characters.value?.firstOrNull { it.character.url?.parseId(CHARACTERS) == id }
    }

    /**
     * Parses the film id's from the path list,
     * Fetches each films from the backend
     * Updates the films liveData list with the Film objects
     * pulled from the backend
     */
    fun setFilms(characterId: Int): LiveDataCharacter? {
        val character = getCharacter(characterId)
        if (character?.films?.value.isNullOrEmpty()) {
            viewModelScope.launch {
                async {
                    val films: List<Film?>? = character?.character?.films?.map { url ->
                        url?.parseId(FILMS)?.let { id ->
                            useCase.getFilm(id)
                        }
                    }
                    films?.filterNotNull()?.let {
                        character.films.postValue(it)
                    }
                }
            }
        }
        return character
    }

    /**
     * Parses the starship id's from the path list,
     * Fetches each starships from the backend
     * Updates the starships liveData list with the Starship objects
     * pulled from the backend
     */
    fun setStarships(characterId: Int): LiveDataCharacter? {
        val character = getCharacter(characterId)
        if (character?.starships?.value.isNullOrEmpty()) {
            viewModelScope.launch {
                async {
                    val starships: List<Starship?>? = character?.character?.starships?.map { url ->
                        url.parseId(STARSHIPS)?.let { id ->
                            useCase.getStarship(id)
                        }
                    }
                    starships?.filterNotNull()?.let {
                        character.starships.postValue(it)
                    }
                }
            }
        }
        return character
    }

    /**
     * Parses the vehicle id's from the path list,
     * Fetches each vehicles from the backend
     * Updates the vehicles liveData list with the Vehicle objects
     * pulled from the backend
     */
    fun setVehicles(characterId: Int): LiveDataCharacter? {
        val character = getCharacter(characterId)
        if (character?.vehicles?.value.isNullOrEmpty()) {
            viewModelScope.launch {
                async {
                    val vehicles: List<Vehicle?>? = character?.character?.vehicles?.map { url ->
                        url.parseId(VEHICLES)?.let { id ->
                            useCase.getVehicle(id)
                        }
                    }
                    vehicles?.filterNotNull()?.let {
                        character.vehicles.postValue(it)
                    }
                }
            }
        }
        return character
    }
}
