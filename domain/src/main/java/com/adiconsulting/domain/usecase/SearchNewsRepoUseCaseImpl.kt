package com.adiconsulting.domain.usecase

import com.adiconsulting.domain.entity.DataEntity
import com.adiconsulting.domain.entity.ListTopHeadlineEntity
import com.adiconsulting.domain.repository.SearchNewsRepository
import kotlinx.coroutines.channels.ReceiveChannel

class SearchNewsRepoUseCaseImpl(private val searchNewsRepository: SearchNewsRepository) : SearchNewsRepoUseCase {

    override suspend fun getListNewsRepos(): ReceiveChannel<DataEntity<List<ListTopHeadlineEntity>>> {
        return searchNewsRepository.getListNews()
    }
}