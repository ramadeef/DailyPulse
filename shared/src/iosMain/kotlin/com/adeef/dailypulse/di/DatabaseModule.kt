package com.adeef.dailypulse.di

import app.cash.sqldelight.db.SqlDriver
import com.adeef.dailypulse.db.DailyPulseDatabase
import com.adeef.dailypulse.db.DatabaseDriverFactory
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> {DatabaseDriverFactory().createDriver()}
    single<DailyPulseDatabase> {DailyPulseDatabase(get())  }
}