package com.adeef.dailypulse.di

import com.adeef.dailypulse.articles.di.articlesModule

val sharedKoinModule = listOf(
    articlesModule,
    networkModule
)