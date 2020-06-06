package com.adiconsulting.data.api

import com.adiconsulting.data.entity.ListTopHeadlineResponse
import com.adiconsulting.data.entity.TopHeadLineNewsResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadlineNewsApi {

    @GET("v2/sources")
    fun getListTopHeadlineNews(
        @Query("apiKey") apiKey: String) : Deferred<List<TopHeadLineNewsResponse>>
}