package com.lekalina.starwars.ui.characters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lekalina.starwars.data.helpers.CHARACTERS
import com.lekalina.starwars.data.helpers.parseId
import com.lekalina.starwars.data.model.LiveDataCharacter
import com.lekalina.starwars.ui.common.Toolbar
import com.lekalina.starwars.ui.lastVisibleItemIndex
import com.lekalina.starwars.ui.navigation.NavRoutes
import com.lekalina.starwars.ui.navigation.NavigationViewModel

@Composable
fun CharactersScreen(
    charsVM: CharactersViewModel,
    navVM: NavigationViewModel
) {
    Surface {
        Column(Modifier.fillMaxSize()) {
            Toolbar(title = "Star Wars Characters")
            CharactersList(charsVM = charsVM) { char ->
                char.character.url?.parseId(CHARACTERS)?.let { id ->
                    navVM.navigate(NavRoutes.CharacterBio.route, id)
                }
            }
        }
    }
}

@Composable
fun CharactersList(
    charsVM: CharactersViewModel,
    onClick: (LiveDataCharacter) -> Unit
) {
    val lazyItems by charsVM.characters.observeAsState()

    lazyItems?.let { characters ->
        LazyColumn(state = charsVM.scrollState) {
            items(characters) { character ->
                CharacterRow(character = character) {
                    onClick(character)
                }
            }
        }
    }
    charsVM.scrollPosition.postValue(charsVM.scrollState.lastVisibleItemIndex())
}

@Composable
fun CharacterRow(
    character: LiveDataCharacter,
    onClick: () -> Unit
) {
    val planet by character.planet.observeAsState()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp, top = 2.dp, bottom = 2.dp)
            .clickable { onClick() },
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Column(modifier = Modifier
            .padding(16.dp)
        ) {
            Text(text = "Name: ${character.character.name}")
            Text(text = "Birth Year: ${character.character.birthYear}")
            planet?.let { homeworld ->
                Text(text = "Homeworld: ${homeworld.name}")
            }
        }
    }
}
