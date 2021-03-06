package com.adiconsulting.dirumahaja.feature.di

import androidx.lifecycle.ViewModelProvider
import com.adiconsulting.dirumahaja.base.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory) : ViewModelProvider.Factory
}