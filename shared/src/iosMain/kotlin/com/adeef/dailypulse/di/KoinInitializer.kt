package com.adeef.dailypulse.di

import com.adeef.dailypulse.articles.presentation.ArticlesViewModel
import com.adeef.dailypulse.sources.presentation.SourcesViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin(){

    val modules = sharedKoinModule + databaseModule

    startKoin {
        modules(modules)
    }


}
class ArticlesInjector : KoinComponent{

    val articlesViewModel: ArticlesViewModel by inject()
}

class SourcesInjector : KoinComponent {

    val sourcesViewModel: SourcesViewModel by inject()
}