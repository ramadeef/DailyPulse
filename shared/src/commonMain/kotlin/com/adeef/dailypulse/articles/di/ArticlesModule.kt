package com.adeef.dailypulse.articles.di

import com.adeef.dailypulse.articles.data.ArticlesDataSource
import com.adeef.dailypulse.articles.data.ArticlesRepository
import com.adeef.dailypulse.articles.data.ArticlesService
import com.adeef.dailypulse.articles.domain.ArticlesUseCase
import com.adeef.dailypulse.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {

    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(),get()) }
}