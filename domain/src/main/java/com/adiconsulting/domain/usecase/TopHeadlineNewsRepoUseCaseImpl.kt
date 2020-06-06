package com.adiconsulting.domain.usecase

import com.adiconsulting.domain.entity.DataEntity
import com.adiconsulting.domain.entity.ListTopHeadlineEntity
import com.adiconsulting.domain.repository.TopHeadLineNewsRepository
import kotlinx.coroutines.channels.ReceiveChannel

class TopHeadlineNewsRepoUseCaseImpl(private val topHeadLineNewsRepository: TopHeadLineNewsRepository) : TopHeadlineNewsRepoUseCase {

    override suspend fun getListTopHeadlineNewsRepos(): ReceiveChannel<DataEntity<List<ListTopHeadlineEntity>>> {
        return topHeadLineNewsRepository.getListTopHeadlineNews()
    }
}