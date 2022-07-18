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
import com.lekalina.starwars.data.model.Vehicle
import com.lekalina.starwars.ui.common.Toolbar

@Composable
fun VehiclesScreen(
    charsVM: CharactersViewModel,
    characterId: Int,
) {
    charsVM.setVehicles(characterId)?.let {
        Column(Modifier.fillMaxSize()) {
            Toolbar(title = "${it.character.name}'s Vehicles")
            VehiclesList(character = it)
        }
    }
}

@Composable
fun VehiclesList(
    character: LiveDataCharacter
) {
    val vehicles by character.vehicles.observeAsState()

    vehicles?.let {
        LazyColumn {
            items(it) { item ->
                Card(Modifier.fillMaxWidth()
                    .padding(start = 4.dp, end = 4.dp, top = 2.dp, bottom = 2.dp)
                ) {
                    VehicleRow(vehicle = item)
                }
            }
        }
    }
}

@Composable
fun VehicleRow(
    vehicle: Vehicle
) {
    Column(Modifier.fillMaxWidth().padding(10.dp)) {
        Text(text = "Name: ${vehicle.name}")
        Text(text = "Model: ${vehicle.model}")
        Text(text = "Manufacturer: ${vehicle.manufacturer}")
        Text(text = "Class: ${vehicle.vehicleClass}")
        Text(text = "Cost: ${vehicle.costInCredits} credits")
    }
}
