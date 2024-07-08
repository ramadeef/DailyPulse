package com.adeef.dailypulse.android.di

import com.adeef.dailypulse.articles.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel{
        ArticlesViewModel(get())
    }
}