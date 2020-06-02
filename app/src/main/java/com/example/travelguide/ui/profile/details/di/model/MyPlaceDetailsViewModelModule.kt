package com.example.travelguide.ui.profile.details.di.model

import androidx.lifecycle.ViewModel
import com.example.travelguide.app.di.module.ViewModelModule
import com.example.travelguide.app.di.scope.ViewModelKey
import com.example.travelguide.ui.profile.details.MyPlaceDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
abstract class MyPlaceDetailsViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(MyPlaceDetailsViewModel::class)
    abstract fun bindMyPlaceDetailsViewModel(
        myPlaceDetailsViewModel: MyPlaceDetailsViewModel
    ): ViewModel

}
