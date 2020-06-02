package com.example.travelguide.profile.details.di.component

import com.example.travelguide.profile.details.MyPlaceDetailsFragment
import com.example.travelguide.profile.details.di.model.MyPlaceDetailsModule
import com.example.travelguide.profile.details.di.model.MyPlaceDetailsViewModelModule
import com.example.travelguide.profile.details.di.scope.MyDetailsScope
import dagger.Subcomponent

@MyDetailsScope
@Subcomponent(modules = [MyPlaceDetailsModule::class, MyPlaceDetailsViewModelModule::class])

interface MyPlaceDetailsComponent {

    fun inject(myPlaceDetailsFragment: MyPlaceDetailsFragment)

    @Subcomponent.Builder
    interface Builder {

        fun provideMyPlaceDetailsModule(myPlaceDetailsModule: MyPlaceDetailsModule): Builder

        fun build(): MyPlaceDetailsComponent
    }
}
