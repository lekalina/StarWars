package com.lekalina.starwars.data.model

import com.google.gson.annotations.SerializedName

data class Characters(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: List<Character>
)
