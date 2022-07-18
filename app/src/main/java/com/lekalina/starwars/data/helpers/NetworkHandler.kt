package com.lekalina.starwars.data.helpers

suspend fun <T : Any> handleRequest(requestFunc: suspend () -> T): T? {
    return try {
        requestFunc.invoke()
    } catch (e: Exception) {
        null
    }
}
