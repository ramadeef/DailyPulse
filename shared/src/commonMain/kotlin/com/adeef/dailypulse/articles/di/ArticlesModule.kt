package com.adeef.dailypulse.articles.di

import com.adeef.dailypulse.articles.ArticlesService
import com.adeef.dailypulse.articles.ArticlesUseCase
import com.adeef.dailypulse.articles.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {

    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> {ArticlesViewModel(get())}

}