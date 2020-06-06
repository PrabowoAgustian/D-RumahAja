package com.adiconsulting.dirumahaja.feature.ui.di

import androidx.lifecycle.ViewModel
import com.adiconsulting.dirumahaja.feature.di.ViewModelKey
import com.adiconsulting.dirumahaja.feature.ui.main.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel) : ViewModel
}