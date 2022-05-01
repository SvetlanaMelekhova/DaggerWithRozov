package com.svetlana.learn.daggerwithrozov.di

import dagger.Module

@Module(includes = [NetworkModule::class, AppBindModule::class])
interface AppModule