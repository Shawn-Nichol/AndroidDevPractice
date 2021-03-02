package com.example.androiddevpractice.di

import android.content.Context
import com.example.androiddevpractice.ui.main.MainActivity
import com.example.androiddevpractice.ui.recyclerview.RecyclerViewFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {

    // Factory to create instances of AppComponent
    @Component.Factory
    interface Factory {
        // @BindInstance, makes the Context available to the graph.
        fun create(@BindsInstance context: Context): AppComponent
    }

    // Classes that can be injected.
    fun inject(activity: MainActivity)
    fun inject(fragment: RecyclerViewFragment)

}