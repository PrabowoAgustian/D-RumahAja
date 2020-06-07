package com.adiconsulting.domain.repository

import com.adiconsulting.domain.entity.DataEntity
import com.adiconsulting.domain.entity.ListTopHeadlineEntity
import kotlinx.coroutines.channels.ReceiveChannel

interface SearchNewsRepository {

    suspend fun getListNews(): ReceiveChannel<DataEntity<List<ListTopHeadlineEntity>>>
}