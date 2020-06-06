package com.adiconsulting.data.maper

import com.adiconsulting.data.entity.TopHeadLineNewsResponse
import com.adiconsulting.domain.entity.ListTopHeadlineEntity

class ResponseDataToDomainEntityMaper {

    fun mapTo(response: List<TopHeadLineNewsResponse>?) :List<ListTopHeadlineEntity> = mapToList(response)

    private fun mapToList(topHeadlineResponse: List<TopHeadLineNewsResponse>?):
            List<ListTopHeadlineEntity> = topHeadlineResponse?.map { mapToDomainEntity(it) } ?: emptyList()

    private fun mapToDomainEntity(it: TopHeadLineNewsResponse): ListTopHeadlineEntity = ListTopHeadlineEntity(
        author = it.articles.author,
        title= it.articles.title,
        urlToImage = it.articles.urlToImage
    )
}