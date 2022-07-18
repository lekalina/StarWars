package com.lekalina.starwars.ui

import androidx.compose.foundation.lazy.LazyListState

fun LazyListState.lastVisibleItemIndex() =
    layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0
