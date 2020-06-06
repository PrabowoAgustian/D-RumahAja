package com.adiconsulting.dirumahaja.feature.maper

import com.adiconsulting.dirumahaja.feature.entity.Data
import com.adiconsulting.dirumahaja.feature.entity.ListTopHeadlineNews
import com.adiconsulting.domain.entity.DataEntity
import com.adiconsulting.domain.entity.ListTopHeadlineEntity

class DomainToPresentationMapper {

    fun mapTo(data: DataEntity<List<ListTopHeadlineEntity>>): Data<List<ListTopHeadlineNews>> {
        return when (data) {
            is DataEntity.SUCCESS -> Data.SUCCESS(data.data?.let { mapToList(it) })
            is DataEntity.ERROR -> Data.ERROR(error =  data.error)
        }
    }

    private fun mapToList(responses: List<ListTopHeadlineEntity>?)
            : List<ListTopHeadlineNews> = responses?.map { mapToPresentationEntity(it) } ?: emptyList()

    private fun mapToPresentationEntity(listTopHeadlineEntity: ListTopHeadlineEntity): ListTopHeadlineNews = ListTopHeadlineNews(
        author = listTopHeadlineEntity.author,
        title = listTopHeadlineEntity.title,
        urlToImage = listTopHeadlineEntity.urlToImage)
}