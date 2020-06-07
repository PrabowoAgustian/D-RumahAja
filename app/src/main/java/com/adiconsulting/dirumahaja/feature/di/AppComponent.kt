package com.adiconsulting.dirumahaja.feature.di

import com.adiconsulting.dirumahaja.DiRumahAja
import com.adiconsulting.dirumahaja.feature.di.scopes.AppScoped
import com.adiconsulting.dirumahaja.feature.ui.di.ActivityBuilderModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@AppScoped
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBuilderModule::class,
    NetworkModule::class,
    ViewModelFactoryModule::class]
)
interface AppComponent : AndroidInjector<DiRumahAja> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: DiRumahAja) : Builder

        fun build() : AppComponent
    }
}