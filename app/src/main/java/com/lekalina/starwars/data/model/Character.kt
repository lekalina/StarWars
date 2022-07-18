package com.lekalina.starwars.data.model

import androidx.lifecycle.MutableLiveData
import com.google.gson.annotations.SerializedName
import java.util.Date

data class Character(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("mass")
    val mass: String? = null,
    @SerializedName("hair_color")
    val hairColor: String? = null,
    @SerializedName("skin_color")
    val skinColor: String? = null,
    @SerializedName("eye_color")
    val eyeColor: String? = null,
    @SerializedName("birth_year")
    val birthYear: String? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("homeworld")
    val homeworld: String? = null,
    @SerializedName("films")
    val films: List<String?>? = null,
    @SerializedName("species")
    val species: List<String?>? = null,
    @SerializedName("vehicles")
    val vehicles: List<String>? = null,
    @SerializedName("starships")
    val starships: List<String>? = null,
    @SerializedName("created")
    val created: Date? = null,
    @SerializedName("edited")
    val edited: Date? = null,
    @SerializedName("url")
    val url: String? = null,
)

class LiveDataCharacter(
    val character: Character,
    var planet: MutableLiveData<Planet?> = MutableLiveData(),
    var films: MutableLiveData<List<Film>> = MutableLiveData(),
    var starships: MutableLiveData<List<Starship>> = MutableLiveData(),
    var vehicles: MutableLiveData<List<Vehicle>> = MutableLiveData()
)

fun Character.toLiveData(): LiveDataCharacter {
    return LiveDataCharacter(
        character = this
    )
}
