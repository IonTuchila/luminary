package com.example.luminary

import com.example.luminary.di.ApplicationModule
import com.example.luminary.di.MockHttpModule

class MockTestApplication {
    class MockTestApplication : LuminaryApp() {

        override fun createComponent() {
            component=  DaggerTestComponent.builder()
                .applicationModule(ApplicationModule(this))
                .mockHttpModule(MockHttpModule())
                .build()
        }
    }
}