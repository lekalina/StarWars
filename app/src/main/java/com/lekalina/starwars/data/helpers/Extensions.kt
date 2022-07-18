package com.lekalina.starwars.data.helpers

import android.net.UrlQuerySanitizer
import java.lang.NumberFormatException

fun String.parseId(url: String): Int? {
    if (!this.contains(url)) {
        return null
    }
    return try {
        this.replace(url, "").replace("/", "").toInt()
    } catch (e: NumberFormatException) {
        null
    }
}

fun String.parseNextPage(): Int? {
    return try {
        val sanitizer = UrlQuerySanitizer()
        sanitizer.parseUrl(this)
        val page = sanitizer.getValue("page")
        page.toInt()
    } catch (e: RuntimeException) {
        null
    }
}
