package com.example.travelguide.data.di.module

import android.content.Context
import androidx.room.Room
import com.example.travelguide.data.db.AppDatabase
import com.example.travelguide.data.db.dao.PlaceDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideBuildDb(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providePlaceDAO(appDatabase: AppDatabase): PlaceDAO = appDatabase.placeDAO()

//    @Singleton
//    @Provides
//    fun providePlaceInteractor(repository: PlaceDbRepository): PlaceDbInteractor =
//        PlaceDbInteractorImpl(repository)
//
//    @Singleton
//    @Provides
//    fun providePlaceRepository(placeDAO: PlaceDAO): PlaceDbRepository =
//        PlaceDbRepositoryImpl(placeDAO)


}
