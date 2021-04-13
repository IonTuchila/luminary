package com.example.luminary.screens.home.mvp

import android.util.Log
import com.example.luminary.net.LuminaryApi
import com.example.luminary.rx.RxThread
import com.example.luminary.screens.home.HomeFragment.Companion.dao
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

open class HomePresenter @Inject constructor(
    private val api: LuminaryApi,
    private val rxThread: RxThread) {

    private lateinit var view: HomeView
    private val disposable = CompositeDisposable()

    fun getUsers() {
        if (dao?.getAll()?.results.isNullOrEmpty()) {
            getUsersFromAPI()
        } else {
            dao?.getAll()?.let { view.setData(it.results) }
        }
    }

    private fun getUsersFromAPI() {
        disposable.add(
            api.getUsers(1, 15)
                .compose(rxThread.applyAsync())
                .subscribe({ response ->
                    run {
                        view.setData(response.results)
                        dao?.insertAll(response)
                    }
                },
                    { t -> view.setOnFail(t.message.toString()) })
        )
    }


    fun injectView(view: HomeView) {
        this.view = view
    }

    fun onStop() {
        disposable.clear()
    }

}