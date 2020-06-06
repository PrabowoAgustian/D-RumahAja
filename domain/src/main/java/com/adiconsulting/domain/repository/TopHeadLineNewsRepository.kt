package com.adiconsulting.domain.repository

import com.adiconsulting.domain.entity.DataEntity
import com.adiconsulting.domain.entity.ListTopHeadlineEntity
import kotlinx.coroutines.channels.ReceiveChannel

interface TopHeadLineNewsRepository {

    suspend fun getListTopHeadlineNews(): ReceiveChannel<DataEntity<List<ListTopHeadlineEntity>>>
}