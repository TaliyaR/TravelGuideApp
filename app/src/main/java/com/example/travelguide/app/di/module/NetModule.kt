package com.example.travelguide.app.di.module

import com.example.travelguide.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
        conventerFactory: GsonConverterFactory,
        callAdapterFactory: RxJava2CallAdapterFactory,
        @Named(TAG_URL) url: String
    ) : Retrofit = Retrofit.Builder()
        .client(client)
        .addConverterFactory(conventerFactory)
        .addCallAdapterFactory(callAdapterFactory)
        .baseUrl(url)
        .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @Named(TAG_AUTH) authInterceptor: Interceptor,
        @Named(TAG_LOGGING) loggingInterceptor: Interceptor,
        @Named(TAG_QUERY) queryInterceptor: Interceptor
    ) : OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(queryInterceptor)
        .addInterceptor(authInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideConventerFactory() : GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideCallAdapterFactory() : RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @Provides
    @Singleton
    @Named(TAG_LANGUAGE)
    fun provideLanguageInterceptor() = Interceptor { chain->
        val newUrl = chain.request().url().newBuilder().addQueryParameter("language", "ru").build()
        val newRequest = chain.request().newBuilder().url(newUrl).build()
        chain.proceed(newRequest)
    }

    @Provides
    @Singleton
    @Named(TAG_QUERY)
    fun provideQueryInterceptor() = Interceptor { chain ->
        val newUrl = chain.request().url().newBuilder().addQueryParameter("query", "sights").build()
        val newRequest = chain.request().newBuilder().url(newUrl).build()
        chain.proceed(newRequest)
    }

    @Provides
    @Singleton
    @Named(TAG_AUTH)
    fun provideAuthInterceptor() = Interceptor { chain ->
        val newUrl = chain.request().url().newBuilder().addQueryParameter("key", BuildConfig.API_KEY).build()
        val newRequest = chain.request().newBuilder().url(newUrl).build()
        chain.proceed(newRequest)
    }

    @Provides
    @Singleton
    @Named(TAG_LOGGING)
    fun provideHttpLogginInterceptor() : Interceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    @Named(TAG_URL)
    fun provideBaseUrl() : String = BuildConfig.API_ENDPOINT

    companion object {
        private const val TAG_LOGGING = "tag_logging"
        private const val TAG_AUTH = "tag_auth"
        private const val TAG_URL = "tag_url"
        private const val TAG_LANGUAGE = "tag_language"
        private const val TAG_QUERY = "tag_query"
    }

}
