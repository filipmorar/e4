//package com.example.e4.utils
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.example.e4.databinding.TaskItemBinding
//import com.example.e4.model.Task
//
//class TaskAdapter (private val clickListener: ClickListener):
//    ListAdapter<Task, TaskAdapter.TaskItemViewHolder>(TagDiffCallback()) {
//
//    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
//        val item = getItem(position)
//        holder.bind(item, clickListener)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder {
//        return TaskItemViewHolder.from(parent)
//    }
//
//    interface ClickListener {
//        fun onClick(tag: String)
//    }
//
//    class TaskItemViewHolder (private val binding: TaskItemBinding):
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(item: Task, clickListener: ClickListener) {
//            binding.clickListener = clickListener
//            binding.task = item
//            binding.executePendingBindings()
//        }
//
//        companion object {
//            fun from(parent: ViewGroup): TaskItemViewHolder {
//                val layoutInflater = LayoutInflater.from(parent.context)
//                val binding = TaskItemBinding.inflate(layoutInflater, parent, false)
//                return TaskItemViewHolder(binding)
//            }
//        }
//    }
//}
