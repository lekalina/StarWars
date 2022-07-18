package com.lekalina.starwars.domain.pagers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lekalina.starwars.data.helpers.API_FIRST_PAGE
import com.lekalina.starwars.data.helpers.PAGING_BUFFER
import com.lekalina.starwars.data.helpers.PLANETS
import com.lekalina.starwars.data.helpers.parseId
import com.lekalina.starwars.data.model.LiveDataCharacter
import com.lekalina.starwars.data.model.toLiveData
import com.lekalina.starwars.data.repos.CharacterRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterPager(
    private val repo: CharacterRepo,
    private val scope: CoroutineScope,
    scrollPosition: LiveData<Int>,
) {

    private var currentPage = API_FIRST_PAGE
    private var nextPage = currentPage + 1
    private var count = 0
    private val list: ArrayList<LiveDataCharacter> = arrayListOf()
    val characters: MutableLiveData<List<LiveDataCharacter>> = MutableLiveData(list)

    init {
        getCharacters()
        scrollPosition.observeForever { position ->
            if ((position + PAGING_BUFFER) > count && currentPage == nextPage) {
                getCharacters()
            }
        }
    }

    private suspend fun loadPage(): List<LiveDataCharacter> {
        nextPage = currentPage + 1
        val response = repo.getCharacters(currentPage)
        val results = response?.results ?: listOf()
        count += results.size
        response?.count?.let { totalItems ->
            if (count < totalItems) {
                currentPage++
            }
        } ?: kotlin.run { currentPage++ }
        return results.map { it.toLiveData() }
    }

    private fun getCharacters() {
        scope.launch(Dispatchers.IO) {
            val pageList = withContext(Dispatchers.IO) { loadPage() }
            async {
                pageList.map { character ->
                    character.character.homeworld?.parseId(PLANETS)?.let { id ->
                        val homeWorld = repo.getHomeworld(id)
                        character.planet.postValue(homeWorld)
                    }
                }
            }
            if (!list.containsAll(pageList)) {
                list.addAll(pageList)
                characters.postValue(list)
            }
        }
    }
}
