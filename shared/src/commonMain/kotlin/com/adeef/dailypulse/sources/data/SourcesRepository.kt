package com.adeef.dailypulse.sources.data


class SourcesRepository(private val dataSource: SourcesDataSource, private val service: SourcesService) {
    suspend fun getSources(forceFerch: Boolean): List<SourceRaw>{
        if(forceFerch){
            dataSource.clearSources()
            fetchSources()
        }

        val articlesDb = dataSource.getAllSources()
        print("Got ${articlesDb.size} from the database")
        if(articlesDb.isEmpty()){
            return fetchSources()
        }
        return articlesDb
    }

    private suspend fun fetchSources(): List<SourceRaw> {
        val fetchedArticles = service.fetchSources()
        dataSource.insertSources(fetchedArticles)
        return fetchedArticles
    }
}