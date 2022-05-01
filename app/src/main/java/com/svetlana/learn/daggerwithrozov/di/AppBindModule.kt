package com.svetlana.learn.daggerwithrozov.di

import com.svetlana.learn.daggerwithrozov.data.NewsRepository
import com.svetlana.learn.daggerwithrozov.data.NewsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindModule {

    @Suppress("FunctionName")
    @Binds
    fun bindNewsRepositoryImpl_to_NewsRepository(
        newsRepositoryImpl: NewsRepositoryImpl
    ): NewsRepository
}