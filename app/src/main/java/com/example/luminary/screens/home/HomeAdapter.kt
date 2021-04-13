package com.example.luminary.screens.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.luminary.databinding.UserItemBinding
import com.example.luminary.net.models.User
import com.squareup.picasso.Picasso


class HomeAdapter(private val onClickListener: (User) -> Unit) : ListAdapter<User, MyEventsVH>(EventDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyEventsVH {
        return MyEventsVH.from(parent,  onClickListener)
    }

    override fun onBindViewHolder(holder: MyEventsVH, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

class MyEventsVH private constructor(val binding: UserItemBinding,private val onClickListener: (User) -> Unit) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: User) {
        binding.user = item

        setUserImage(item)
        binding.root.setOnClickListener { onClickListener(item) }
        binding.executePendingBindings()
    }

    private fun setUserImage(item: User) {
        Picasso.get().load(item.picture?.medium).into(binding.userImage)
    }

    companion object {
        fun from(parent: ViewGroup, onClickListener: (User) -> Unit ): MyEventsVH {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = UserItemBinding.inflate(layoutInflater, parent, false)
            return MyEventsVH(binding, onClickListener)
        }
    }
}

class EventDiffCallback : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.name == newItem.name
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

}
