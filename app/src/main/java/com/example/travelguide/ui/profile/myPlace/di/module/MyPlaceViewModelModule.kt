package com.example.travelguide.ui.profile.myPlace.di.module

import androidx.lifecycle.ViewModel
import com.example.travelguide.app.di.module.ViewModelModule
import com.example.travelguide.app.di.scope.ViewModelKey
import com.example.travelguide.ui.profile.myPlace.MyPlaceViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
abstract class MyPlaceViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(MyPlaceViewModel::class)
    abstract fun bindMyPlaceViewModel(
        myPlaceViewModel: MyPlaceViewModel
    ): ViewModel
}
