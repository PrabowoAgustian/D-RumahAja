package com.adiconsulting.dirumahaja.feature.ui.di

import com.adiconsulting.data.api.NewsApi
import com.adiconsulting.data.repository.TopHeadlineNewsRepositoryImpl
import com.adiconsulting.domain.repository.TopHeadLineNewsRepository
import com.adiconsulting.domain.usecase.TopHeadlineNewsRepoUseCase
import com.adiconsulting.domain.usecase.TopHeadlineNewsRepoUseCaseImpl
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
    internal fun provideNewseRepository( api: NewsApi): TopHeadLineNewsRepository {
        return TopHeadlineNewsRepositoryImpl(api)
    }

    @Provides
    internal fun provideNewsRepoUseCase( topHeadlineNewsRepository: TopHeadLineNewsRepository): TopHeadlineNewsRepoUseCase {
        return TopHeadlineNewsRepoUseCaseImpl(topHeadlineNewsRepository)
    }
}