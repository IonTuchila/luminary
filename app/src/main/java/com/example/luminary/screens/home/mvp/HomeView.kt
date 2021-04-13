package com.example.luminary.screens.home.mvp

import com.example.luminary.di.ui.BaseView
import com.example.luminary.net.models.User
import com.example.luminary.net.response.UserResponse

interface HomeView : BaseView {

    fun setData(users: List<User>)

    fun setOnFail(msg: String)

}