package com.adiconsulting.data.api

import com.adiconsulting.data.entity.TopHeadLineNewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadlineNewsApi {

    @GET("v2/top-headlines")
    fun getListTopHeadlineNews(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String) : Call<List<TopHeadLineNewsResponse>>
//            Deferred<List<TopHeadLineNewsResponse>>
}