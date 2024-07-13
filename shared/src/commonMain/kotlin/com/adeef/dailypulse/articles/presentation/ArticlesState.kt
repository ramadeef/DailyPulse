package com.adeef.dailypulse.articles.presentation

import com.adeef.dailypulse.articles.domain.Article

data class ArticlesState (
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)
