package com.example.travelguide.profile.add.di.model

import androidx.lifecycle.ViewModel
import com.example.travelguide.data.di.module.ViewModelModule
import com.example.travelguide.data.di.scope.ViewModelKey
import com.example.travelguide.profile.add.AddPlaceViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
abstract class AddPlaceViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(AddPlaceViewModel::class)
    abstract fun bindAddPlaceViewModel(
        addPlaceViewModel: AddPlaceViewModel
    ): ViewModel

}
