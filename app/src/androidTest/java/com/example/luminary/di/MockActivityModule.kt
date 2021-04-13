package com.example.luminary.di

import android.app.Activity
import android.content.Context
import com.example.luminary.di.scope.ActivityContext
import dagger.Module
import dagger.Provides
import org.mockito.Mockito

@Module
class MockActivityModule() {

    @Provides
    @ActivityContext
    fun provideContext(): Context = Mockito.mock(Activity::class.java)
}