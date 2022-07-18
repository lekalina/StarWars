package com.lekalina.starwars.ui.characters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lekalina.starwars.data.model.LiveDataCharacter
import com.lekalina.starwars.data.model.Starship
import com.lekalina.starwars.ui.common.Toolbar

@Composable
fun StarshipsScreen(
    charsVM: CharactersViewModel,
    characterId: Int,
) {
    charsVM.setStarships(characterId)?.let {
        Column(Modifier.fillMaxSize()) {
            Toolbar(title = "${it.character.name}'s Starships")
            StarshipList(character = it)
        }
    }
}

@Composable
fun StarshipList(
    character: LiveDataCharacter
) {
    val films by character.starships.observeAsState()

    films?.let {
        LazyColumn {
            items(it) { item ->
                Card(Modifier.fillMaxWidth()
                    .padding(start = 4.dp, end = 4.dp, top = 2.dp, bottom = 2.dp)
                ) {
                    StarshipRow(starship = item)
                }
            }
        }
    }
}

@Composable
fun StarshipRow(
    starship: Starship
) {
    Column(Modifier.fillMaxWidth().padding(10.dp)) {
        Text(text = "Name: ${starship.name}")
        Text(text = "Model: ${starship.model}")
        Text(text = "Manufacturer: ${starship.manufacturer}")
        Text(text = "Crew: ${starship.crew}")
        Text(text = "Cost: ${starship.costInCredits} credits")
    }
}
