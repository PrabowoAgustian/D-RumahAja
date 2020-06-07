package com.adiconsulting.dirumahaja.feature.ui.di

import androidx.lifecycle.ViewModel
import com.adiconsulting.dirumahaja.feature.di.ViewModelKey
import com.adiconsulting.dirumahaja.feature.ui.search.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SearchViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindHomeViewModel(searchViewModel: SearchViewModel) : ViewModel
}