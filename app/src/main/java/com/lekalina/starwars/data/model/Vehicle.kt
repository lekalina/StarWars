package com.lekalina.starwars.data.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Vehicle(
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
    val crew: String? = null,
    @SerializedName("passengers")
    val passengers: String? = null,
    @SerializedName("cargo_capacity")
    val cargoCapacity: String? = null,
    @SerializedName("consumables")
    val consumables: String? = null,
    @SerializedName("vehicle_class")
    val vehicleClass: String? = null, // class
    @SerializedName("created")
    val created: Date? = null,
    @SerializedName("edited")
    val edited: Date? = null,
    @SerializedName("url")
    val url: String? = null,
)
