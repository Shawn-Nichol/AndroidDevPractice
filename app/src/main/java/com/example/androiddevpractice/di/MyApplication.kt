package com.example.androiddevpractice.di

import android.app.Application

class MyApplication: Application() {
    // Instance of the AppComponent that will b used by all the Activities in the project.
    val appComponent: AppComponent by lazy {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        DaggerAppComponent.factory().create(applicationContext)
    }
}