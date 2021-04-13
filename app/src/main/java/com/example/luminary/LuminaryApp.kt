package com.example.luminary

import android.app.Application
import com.example.luminary.di.AppComponent
import com.example.luminary.di.ApplicationModule
import com.example.luminary.di.DaggerAppComponent
import com.example.luminary.di.HttpModule

open class LuminaryApp  : Application(){

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        createComponent()
    }

    protected open fun createComponent() {
        component = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(this))
            .httpModule(HttpModule())
            .build()
    }

}