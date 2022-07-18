package com.lekalina.starwars.data.model

import com.google.gson.annotations.SerializedName
import java.util.Date

@Suppress("ConstructorParameterNaming")
data class Starship(
    @SerializedName("name")
    val name: String? = null, // name
    @SerializedName("model")
    val model: String? = null, // model
    @SerializedName("manufacturer")
    val manufacturer: String? = null, // manufacturer
    @SerializedName("cost_in_credits")
    val costInCredits: String? = null, // cost
    @SerializedName("length")
    val length: String? = null,
    @SerializedName("max_atmosphering_speed")
    val maxAtmospheringSpeed: String? = null,
    @SerializedName("crew")
    val crew: String? = null, // crew
    @SerializedName("passengers")
    val passengers: String? = null,
    @SerializedName("cargo_capacity")
    val cargoCapacity: String? = null,
    @SerializedName("consumables")
    val consumables: String? = null,
    @SerializedName("hyperdrive_rating")
    val hyperdriveRating: String? = null,
    @SerializedName("MGLT")
    val MegaLights: String? = null,
    @SerializedName("starship_class")
    val starshipClass: String? = null,
    @SerializedName("created")
    val created: Date? = null,
    @SerializedName("edited")
    val edited: Date? = null,
    @SerializedName("url")
    val url: String? = null,
)
