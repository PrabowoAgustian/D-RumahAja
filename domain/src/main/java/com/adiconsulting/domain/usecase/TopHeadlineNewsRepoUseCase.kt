package com.adiconsulting.domain.usecase

import com.adiconsulting.domain.entity.DataEntity
import com.adiconsulting.domain.entity.DataTopHeadline
import com.adiconsulting.domain.entity.ListTopHeadlineEntity
import kotlinx.coroutines.channels.ReceiveChannel

interface TopHeadlineNewsRepoUseCase {

    suspend fun getListTopHeadlineNewsRepos(): ReceiveChannel<DataEntity<List<ListTopHeadlineEntity>>>
}