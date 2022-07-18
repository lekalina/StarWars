package com.lekalina.starwars.data.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Film(
    @SerializedName("title")
    val title: String? = null, // movie title
    @SerializedName("episode_id")
    val episodeId: Int? = null, // episode id
    @SerializedName("opening_crawl")
    val openingCrawl: String? = null, // opening crawl
    @SerializedName("director")
    val director: String? = null,
    @SerializedName("producer")
    val producer: String? = null,
    @SerializedName("release_date")
    val releaseDate: String? = null,
    @SerializedName("created")
    val created: Date? = null,
    @SerializedName("edited")
    val edited: Date? = null,
    @SerializedName("url")
    val url: String? = null,
)
