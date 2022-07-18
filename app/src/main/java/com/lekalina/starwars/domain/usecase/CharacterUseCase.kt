package com.lekalina.starwars.domain.usecase

import androidx.lifecycle.LiveData
import com.lekalina.starwars.data.repos.CharacterRepo
import com.lekalina.starwars.domain.pagers.CharacterPager
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class CharacterUseCase @Inject constructor(
    private val repo: CharacterRepo
) {

    fun characterPager(
        scope: CoroutineScope,
        scrollPosition: LiveData<Int>
    ) = CharacterPager(
        repo = repo,
        scope = scope,
        scrollPosition = scrollPosition
    )

    suspend fun getFilm(id: Int) = repo.getFilm(id)
    suspend fun getStarship(id: Int) = repo.getStarship(id)
    suspend fun getVehicle(id: Int) = repo.getVehicle(id)
}
