package com.example.luminary.view.activity

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.example.luminary.LuminaryApp
import com.example.luminary.activity.MainActivity
import com.example.luminary.di.component.TestComponent
import com.example.luminary.util.URL
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private val server by lazy { MockWebServer() }

    @get:Rule
    val activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java, true, false)

    @Before
    fun setUp() {
        server.start(4000)
        URL.BASE_URL = server.url("/").toString()

        val instrument = InstrumentationRegistry.getInstrumentation()
        val app = instrument.targetContext.applicationContext as LuminaryApp
        val component = app.component as TestComponent
        component.inject(this)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}
