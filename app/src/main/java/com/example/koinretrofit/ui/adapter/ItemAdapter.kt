package com.example.koinretrofit.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.koinretrofit.data.model.PostModelItem
import com.example.koinretrofit.databinding.ItemBinding
import com.example.koinretrofit.ui.viewholder.ItemVH

class ItemAdapter : ListAdapter<PostModelItem, ItemVH>(DIFFUTILS) {

    companion object{
        val DIFFUTILS = object : DiffUtil.ItemCallback<PostModelItem>() {
            override fun areItemsTheSame(oldItem: PostModelItem, newItem: PostModelItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: PostModelItem, newItem: PostModelItem): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        val l = LayoutInflater.from(parent.context)
        val v = ItemBinding.inflate(l, parent, false)
        return ItemVH(v)
    }

    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        holder.binding.apply {
            item = getItem(position)
        }
    }
}