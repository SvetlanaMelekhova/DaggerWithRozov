package com.svetlana.learn.daggerwithrozov.di

import com.svetlana.learn.daggerwithrozov.MainActivity
import com.svetlana.learn.daggerwithrozov.NewsDetailsFragment
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: NewsDetailsFragment)
}