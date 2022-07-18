package com.lekalina.starwars.ui.characters

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lekalina.starwars.data.model.LiveDataCharacter
import com.lekalina.starwars.ui.common.Toolbar
import com.lekalina.starwars.ui.navigation.NavRoutes
import com.lekalina.starwars.ui.navigation.NavigationViewModel

@Composable
fun CharacterBioScreen(
    navVM: NavigationViewModel,
    charsVM: CharactersViewModel,
    characterId: Int,
) {
    charsVM.getCharacter(characterId)?.let {
        Column(Modifier.fillMaxSize()) {
            Toolbar(title = "Character Bio")
            CharacterBio(character = it)
            CharacterBioButtons(character = it) { route ->
                navVM.navigate(route, characterId)
            }
        }
    }
}

@Composable
fun CharacterBio(
    character: LiveDataCharacter
) {
    val planet by character.planet.observeAsState()

    Column(modifier = Modifier
        .padding(16.dp)
    ) {
        Text(text = "Name: ${character.character.name}")
        Text(text = "Height: ${character.character.height}")
        Text(text = "Mass: ${character.character.mass}")
        Text(text = "Hair Color: ${character.character.hairColor}")
        Text(text = "Skin Color: ${character.character.skinColor}")
        Text(text = "Birth Year: ${character.character.birthYear}")
        Text(text = "Gender: ${character.character.gender}")
        planet?.let { homeworld ->
            Text(text = "Homeworld: ${homeworld.name}")
        }
    }
}

@Composable
fun CharacterBioButtons(
    character: LiveDataCharacter,
    onClick: (String) -> Unit
) {
    Row(Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        if ((character.character.films?.size ?: 0) > 0) {
            Button(
                onClick = { onClick(NavRoutes.Films.route) },
                modifier = Modifier.padding(start = 5.dp, end = 5.dp)
            ) {
                Text(text = "Films")
            }
        }
        if ((character.character.vehicles?.size ?: 0) > 0) {
            Button(
                onClick = { onClick(NavRoutes.Vehicles.route) },
                modifier = Modifier.padding(start = 5.dp, end = 5.dp)
            ) {
                Text(text = "Vehicles")
            }
        }
        if ((character.character.starships?.size ?: 0) > 0) {
            Button(
                onClick = { onClick(NavRoutes.Starships.route) },
                modifier = Modifier.padding(start = 5.dp, end = 5.dp)
            ) {
                Text(text = "Starships")
            }
        }
    }
}
