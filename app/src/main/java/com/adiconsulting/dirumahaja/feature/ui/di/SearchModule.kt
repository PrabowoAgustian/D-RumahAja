package com.adiconsulting.dirumahaja.feature.ui.di

import com.adiconsulting.data.api.NewsApi
import com.adiconsulting.data.repository.SearchNewsRepositoryImpl
import com.adiconsulting.domain.repository.SearchNewsRepository
import com.adiconsulting.domain.usecase.SearchNewsRepoUseCase
import com.adiconsulting.domain.usecase.SearchNewsRepoUseCaseImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class SearchModule {

    @Provides
    internal fun provideeNewsRepoApi(retrofit: Retrofit): NewsApi {
        return retrofit.create(NewsApi::class.java)
    }

    @Provides
    internal fun provideNewseRepository( api: NewsApi): SearchNewsRepository {
        return SearchNewsRepositoryImpl(api)
    }

    @Provides
    internal fun provideNewsRepoUseCase( searchNewsRepository: SearchNewsRepository): SearchNewsRepoUseCase {
        return SearchNewsRepoUseCaseImpl(searchNewsRepository)
    }
}