package com.adiconsulting.dirumahaja.feature.ui.di

import com.adiconsulting.data.api.TopHeadlineNewsApi
import com.adiconsulting.data.repository.TopHeadlineNewsRepositoryImpl
import com.adiconsulting.domain.repository.TopHeadLineNewsRepository
import com.adiconsulting.domain.usecase.TopHeadlineNewsRepoUseCase
import com.adiconsulting.domain.usecase.TopHeadlineNewsRepoUseCaseImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class HomeModule {
    @Provides
    internal fun provideTopHeadlineNewsRepoApi(retrofit: Retrofit): TopHeadlineNewsApi {
        return retrofit.create(TopHeadlineNewsApi::class.java)
    }

    @Provides
    internal fun provideTopHeadlineNewseRepository( api: TopHeadlineNewsApi): TopHeadLineNewsRepository {
        return TopHeadlineNewsRepositoryImpl(api)
    }

    @Provides
    internal fun provideTopHeadlineNewsRepoUseCase( topHeadlineNewsRepository: TopHeadLineNewsRepository): TopHeadlineNewsRepoUseCase {
        return TopHeadlineNewsRepoUseCaseImpl(topHeadlineNewsRepository)
    }
}