package com.adeef.dailypulse.articles.data

class ArticlesRepository(private val dataSource: ArticlesDataSource, private val service: ArticlesService) {
    suspend fun getArticles(forceFerch: Boolean): List<ArticleRaw>{
        if(forceFerch){
            dataSource.clearArticles()
            fetachArticles()
        }

        val articlesDb = dataSource.getAllArticles()
        print("Got ${articlesDb.size} from the database")
        if(articlesDb.isEmpty()){
            return fetachArticles()
        }
        return articlesDb
    }

    private suspend fun fetachArticles(): List<ArticleRaw> {
        val fetchedArticles = service.fetchArticles()
        dataSource.insertArticles(fetchedArticles)
        return fetchedArticles
    }
}