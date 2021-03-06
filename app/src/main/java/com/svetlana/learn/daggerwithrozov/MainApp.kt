package com.svetlana.learn.daggerwithrozov

import android.app.Application
import android.content.Context
import com.svetlana.learn.daggerwithrozov.di.AppComponent
import com.svetlana.learn.daggerwithrozov.di.DaggerAppComponent

class MainApp : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApp -> appComponent
        else -> applicationContext.appComponent
    }