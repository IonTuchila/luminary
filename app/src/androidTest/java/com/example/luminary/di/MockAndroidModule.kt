package com.example.luminary.di

import androidx.browser.customtabs.CustomTabsIntent
import dagger.Module
import dagger.Provides
import org.mockito.Mockito
import javax.inject.Singleton

@Module
class MockAndroidModule {

    @Provides
    @Singleton
    fun provideCustomTabsBuilder(): CustomTabsIntent.Builder =
        Mockito.mock(CustomTabsIntent.Builder::class.java)

    @Provides
    @Singleton
    fun provideCustomTabsIntent(): CustomTabsIntent = Mockito.mock(CustomTabsIntent::class.java)

}