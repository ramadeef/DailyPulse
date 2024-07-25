package com.adeef.dailypulse.sources.domain

import com.adeef.dailypulse.sources.data.SourceRaw
import com.adeef.dailypulse.sources.data.SourcesRepository

class SourcesUseCase(private val repo: SourcesRepository) {
    suspend fun getSources(forceFetch: Boolean): List<Source> {
        val sourcesRaw = repo.getSources(forceFetch)
        return mapSources(sourcesRaw)
    }

    private fun mapSources(sourcesRaw: List<SourceRaw>): List<Source> = sourcesRaw.map { raw ->
        Source(raw.id,
            raw.name,
            raw.description,
            getOrigin(raw))
    }

    private fun getOrigin(raw:SourceRaw): String{
        return raw.country + " ~ "+ raw.language
    }

}