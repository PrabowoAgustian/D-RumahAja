package com.adiconsulting.data.api

import com.adiconsulting.data.entity.TopHeadLineNewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApi {

    @Headers("Content-Type: application/json")
    @GET("v2/top-headlines")
    fun getListTopHeadlineNews(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String) : Call<List<TopHeadLineNewsResponse>>
//            Deferred<List<TopHeadLineNewsResponse>>

    @Headers("Content-Type: application/json")
    @GET("v2/everything")
    fun doSearchNews(
        @Query("q") keyWord: String,
        @Query("apiKey") apiKey: String) : Call<List<TopHeadLineNewsResponse>>
}