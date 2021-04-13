package com.example.luminary.di

import com.example.luminary.activity.MainActivity
import com.example.luminary.screens.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, AndroidModule::class, HttpModule::class, RxThreadModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: HomeFragment)

}