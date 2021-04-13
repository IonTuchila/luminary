package com.example.luminary.di

import androidx.browser.customtabs.CustomTabsIntent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidModule {

    @Provides
    @Singleton
    fun provideCustomTabsBuilder(): CustomTabsIntent.Builder = CustomTabsIntent.Builder()

    @Provides
    @Singleton
    fun provideCustomTabsIntent(builder: CustomTabsIntent.Builder): CustomTabsIntent = builder.build()

}