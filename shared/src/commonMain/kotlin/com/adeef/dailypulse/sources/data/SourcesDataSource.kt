package com.adeef.dailypulse.sources.data

import com.adeef.dailypulse.db.DailyPulseDatabase

class SourcesDataSource (private val database: DailyPulseDatabase) {
    fun getAllSources(): List<SourceRaw> =
        database.dailyPulseDatabaseQueries.selectAllSources(::mapToSourceRaw).executeAsList()

    fun insertSources(sources: List<SourceRaw>) {
        database.dailyPulseDatabaseQueries.transaction {
            sources.forEach { sourceRaw ->
                insertSource(sourceRaw)
            }
        }
    }

    fun clearSources() =
        database.dailyPulseDatabaseQueries.removeAllArticles()

    private fun insertSource(sourceRaw: SourceRaw) {
        database.dailyPulseDatabaseQueries.insertSource(
            sourceRaw.id,
            sourceRaw.name,
            sourceRaw.description,
            sourceRaw.url,
            sourceRaw.category,
            sourceRaw.language,
            sourceRaw.country
        )
    }

    private fun mapToSourceRaw(
        id: String,
        name: String,
        desc: String,
        url: String,
        category: String,
        language: String,
        country: String
    ): SourceRaw =
        SourceRaw(
            id,
            name,
            desc,
            url,
            category,
            language,
            country
        )
}