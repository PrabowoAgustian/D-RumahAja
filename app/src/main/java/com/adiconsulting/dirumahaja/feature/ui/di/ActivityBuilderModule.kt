package com.adiconsulting.dirumahaja.feature.ui.di

import com.adiconsulting.dirumahaja.feature.di.scopes.ActivityScoped
import com.adiconsulting.dirumahaja.feature.ui.main.HomeActivity
import com.adiconsulting.dirumahaja.feature.ui.main.HomeViewModel
import com.adiconsulting.dirumahaja.feature.ui.search.SearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * This Class {@linkplain ActivityBuilderModule} is responsible for for android injection
 * for the activity with in the application to avoid the seprate injection in each activity
 *
 * {@linkplain dagger.android.AndroidInjection}
 *
 * {@link HomeViewModelModule} can be access from Auth Activity
 * only so it is the concept of sub-modules
 *
 */

@Module abstract class ActivityBuilderModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [HomeViewModelModule::class, HomeModule::class])
    abstract fun contributeHomeActivity(): HomeActivity?

    @ActivityScoped
    @ContributesAndroidInjector(modules = [SearchViewModelModule::class, SearchModule::class])
    abstract fun contributeSearchActivity(): SearchActivity?
}