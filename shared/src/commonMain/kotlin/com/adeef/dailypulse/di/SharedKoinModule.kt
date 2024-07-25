package com.adeef.dailypulse.di

import com.adeef.dailypulse.articles.di.articlesModule
import com.adeef.dailypulse.sources.di.sourcesModule

val sharedKoinModule = listOf(
    articlesModule,
    sourcesModule,
    networkModule
)