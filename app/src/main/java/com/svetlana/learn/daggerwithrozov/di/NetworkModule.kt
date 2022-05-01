package com.svetlana.learn.daggerwithrozov.di

import com.svetlana.learn.daggerwithrozov.data.NewsService
import com.svetlana.learn.daggerwithrozov.di.qualifier.Stage
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
class NetworkModule {

    @Provides
    fun provideProductionNewsService(): NewsService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://androidbrodcast.dev")
            .build()
        return retrofit.create()
    }

    @Provides
    @Stage
    fun provideStageNewsService(): NewsService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://stage.androidbrodcast.dev")
            .build()
        return retrofit.create()
    }
}