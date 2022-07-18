package com.lekalina.starwars.data.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Planet(
    @SerializedName("name")
    val name: String? = null, // homeworld
    @SerializedName("rotation_period")
    val rotationPeriod: String? = null,
    @SerializedName("orbital_period")
    val orbitalPeriod: String? = null,
    @SerializedName("diameter")
    val diameter: String? = null,
    @SerializedName("climate")
    val climate: String? = null,
    @SerializedName("gravity")
    val gravity: String? = null,
    @SerializedName("terrain")
    val terrain: String? = null,
    @SerializedName("surface_water")
    val surfaceWater: String? = null,
    @SerializedName("population")
    val population: String? = null,
    @SerializedName("created")
    val created: Date? = null,
    @SerializedName("edited")
    val edited: Date? = null,
    @SerializedName("url")
    val url: String? = null,
)
