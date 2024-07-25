package com.adeef.dailypulse.sources.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SourcesService(private val httpClient: HttpClient) {
    private val country = "us"
    private val category = "business"
    private val apiKey = "e3980550655b4aa096d4bd6c508447e8"

    suspend fun fetchSources(): List<SourceRaw>{
        val response: SourcesResponse = httpClient.get("https://newsapi.org/v2/top-headlines/sources?country=$country&category=$category&apikey=$apiKey").body()
        return response.sources
    }
}