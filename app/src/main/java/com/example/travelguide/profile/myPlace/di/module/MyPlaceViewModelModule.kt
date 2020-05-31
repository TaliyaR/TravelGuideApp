package com.example.travelguide.profile.myPlace.di.module

import androidx.lifecycle.ViewModel
import com.example.travelguide.data.di.module.ViewModelModule
import com.example.travelguide.data.di.scope.ViewModelKey
import com.example.travelguide.profile.myPlace.MyPlaceViewModel
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
