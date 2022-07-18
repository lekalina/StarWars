package com.lekalina.starwars.ui.characters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.lekalina.starwars.data.model.Film
import com.lekalina.starwars.data.model.LiveDataCharacter
import com.lekalina.starwars.ui.common.Toolbar

@Composable
fun FilmsScreen(
    charsVM: CharactersViewModel,
    characterId: Int,
) {
    charsVM.setFilms(characterId)?.let {
        Column(Modifier.fillMaxSize()) {
            Toolbar(title = "${it.character.name}'s Films")
            FilmsList(character = it)
        }
    }
}

@Composable
fun FilmsList(
    character: LiveDataCharacter
) {
    val films by character.films.observeAsState()

    films?.let {
        LazyColumn {
            items(it) { item ->
                Card(Modifier.fillMaxWidth()
                    .padding(start = 4.dp, end = 4.dp, top = 2.dp, bottom = 2.dp)
                ) {
                    FilmRow(film = item)
                }
            }
        }
    }
}

@Composable
fun FilmRow(
    film: Film
) {
    Column(Modifier.fillMaxWidth().padding(16.dp)) {
        Text(
            modifier = Modifier.padding(bottom = 3.dp),
            text = "Episode ${film.episodeId} - ${film.title}",
            fontWeight = FontWeight.Bold
        )
        Divider()
        Text(
            modifier = Modifier.padding(top = 3.dp),
            text = "${film.openingCrawl}"
        )
    }
}
