package com.example.travelguide.ui.profile.add.di.component

import com.example.travelguide.ui.profile.add.AddPlaceFragment
import com.example.travelguide.ui.profile.add.di.model.AddPlaceModule
import com.example.travelguide.ui.profile.add.di.model.AddPlaceViewModelModule
import com.example.travelguide.ui.profile.add.di.scope.AddPlaceScope
import dagger.Subcomponent

@AddPlaceScope
@Subcomponent(modules = [AddPlaceModule::class, AddPlaceViewModelModule::class])
interface AddMyPlaceComponent {

    fun inject(addPlaceFragment: AddPlaceFragment)

    @Subcomponent.Builder
    interface Builder {

        fun provideAddPlaceModule(addPlaceModule: AddPlaceModule): Builder

        fun build(): AddMyPlaceComponent

    }

}
