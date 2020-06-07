package com.adiconsulting.data.repository

import com.adiconsulting.data.api.NewsApi
import com.adiconsulting.data.maper.ResponseDataToDomainEntityMaper
import com.adiconsulting.domain.entity.DataEntity
import com.adiconsulting.domain.entity.ListTopHeadlineEntity
import com.adiconsulting.domain.repository.TopHeadLineNewsRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import retrofit2.await

class TopHeadlineNewsRepositoryImpl(private val api: NewsApi) : TopHeadLineNewsRepository {

    private var apiKey : String = "6a45206cc3a6432e95aa913a1e53d749"
    private var country : String = "id"
    private var mapper = ResponseDataToDomainEntityMaper()

    override suspend fun getListTopHeadlineNews(): ReceiveChannel<DataEntity<List<ListTopHeadlineEntity>>> {
        return GlobalScope.produce {
            try {
                val repoResponse = api.getListTopHeadlineNews(country,apiKey).await()
                send(DataEntity.SUCCESS(mapper.mapTo((repoResponse))))
            } catch (e: Exception){
                send(DataEntity.ERROR(""+e.message))
            }
        }
    }
}