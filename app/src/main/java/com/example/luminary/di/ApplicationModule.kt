package com.example.luminary.di

import android.app.Application
import android.content.Context
import android.view.inputmethod.InputMethodManager
import com.example.luminary.di.scope.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Application = this.application

}