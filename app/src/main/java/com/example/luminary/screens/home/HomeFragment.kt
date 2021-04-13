package com.example.luminary.screens.home

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.luminary.LuminaryApp
import com.example.luminary.R
import com.example.luminary.database.ProjectRoomDatabase
import com.example.luminary.database.UserDAO
import com.example.luminary.net.models.User
import com.example.luminary.net.response.UserResponse
import com.example.luminary.screens.home.mvp.HomePresenter
import com.example.luminary.screens.home.mvp.HomeView
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : Fragment(R.layout.fragment_home), HomeView {

    @Inject
    lateinit var presenter: HomePresenter
    private lateinit var adapter: HomeAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as LuminaryApp).component.inject(this)
        presenter.injectView(this)

    }

    override fun setData(users: List<User>) {
        adapter = HomeAdapter {
            Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show()
        }
        recycler.adapter = adapter
        adapter.submitList(users)
    }

    override fun setOnFail(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = context?.let { ProjectRoomDatabase.getDatabase(it) }
        dao = db?.userAccountDao()
        setupRecycler()
        presenter.getUsers()
    }

    private fun setupRecycler() {
        recycler.apply {
            this.layoutManager = LinearLayoutManager(this.context)
            itemAnimator = DefaultItemAnimator()
        }
    }

    /**
     * Called when the Fragment is no longer started.  This is generally
     * tied to [Activity.onStop] of the containing
     * Activity's lifecycle.
     */
    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    companion object{
        var dao : UserDAO? = null
    }

}
