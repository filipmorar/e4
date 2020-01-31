package com.example.e4.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.e4.databinding.TagItemBinding
import com.example.e4.model.Tag

class TagAdapter (private val clickListener: ClickListener):
    ListAdapter<Tag, TagAdapter.TagItemViewHolder>(TagDiffCallback()) {

    override fun onBindViewHolder(holder: TagItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagItemViewHolder {
        return TagItemViewHolder.from(parent)
    }

    interface ClickListener {
        fun onClick(tag: String)
    }

    class TagItemViewHolder (private val binding: TagItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Tag, clickListener: ClickListener) {
            binding.clickListener = clickListener
            binding.myTag = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): TagItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TagItemBinding.inflate(layoutInflater, parent, false)
                return TagItemViewHolder(binding)
            }
        }
    }
}

class TagDiffCallback: DiffUtil.ItemCallback<Tag>() {
    override fun areItemsTheSame(oldItem: Tag, newItem: Tag): Boolean {
        return oldItem.tagString == newItem.tagString
    }

    override fun areContentsTheSame(oldItem: Tag, newItem: Tag): Boolean {
        return oldItem == newItem
    }
}