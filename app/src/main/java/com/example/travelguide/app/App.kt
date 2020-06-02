package com.example.travelguide.app

import android.app.Application
import com.example.travelguide.app.di.Injector

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.init(this)
    }

}
