package com.example.luminary.di.component

import com.example.luminary.di.*
import com.example.luminary.view.activity.MainActivityTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(MockHttpModule::class), (ApplicationModule::class),
    (AndroidModule::class), (RxThreadModule::class)]
)
interface TestComponent : AppComponent {
    fun inject(activity: MainActivityTest)
}