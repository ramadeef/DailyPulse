package com.adeef.dailypulse.sources.presentation

import com.adeef.dailypulse.articles.domain.Article
import com.adeef.dailypulse.sources.domain.Source

data class SourcesState(
    val sources: List<Source> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)
