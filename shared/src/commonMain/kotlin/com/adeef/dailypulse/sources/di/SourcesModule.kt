package com.adeef.dailypulse.sources.di

import com.adeef.dailypulse.sources.data.SourcesDataSource
import com.adeef.dailypulse.sources.data.SourcesRepository
import com.adeef.dailypulse.sources.data.SourcesService
import com.adeef.dailypulse.sources.domain.SourcesUseCase
import com.adeef.dailypulse.sources.presentation.SourcesViewModel
import org.koin.dsl.module

val sourcesModule = module {

    single<SourcesService> { SourcesService(get()) }
    single<SourcesUseCase> { SourcesUseCase(get()) }
    single<SourcesViewModel> { SourcesViewModel(get()) }
    single<SourcesDataSource> { SourcesDataSource(get()) }
    single<SourcesRepository> { SourcesRepository(get(),get()) }
}