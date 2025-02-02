package com.example.jetpackarcitecturecomponetspractice.diffUtilAndListAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackarcitecturecomponetspractice.R


class ProgrammingAdapter:ListAdapter<ProgrammingItem,ProgrammingAdapter.ProgrammingViewHolder>(Difffutil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return ProgrammingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgrammingViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
    class ProgrammingViewHolder(view: View): RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.name1)
        val initial = view.findViewById<TextView>(R.id.initial)

        fun bind(item: ProgrammingItem){
            name.text = item.name
            initial.text = item.initial
        }
    }

    class Difffutil: androidx.recyclerview.widget.DiffUtil.ItemCallback<ProgrammingItem>(){
        override fun areItemsTheSame(oldItem: ProgrammingItem, newItem: ProgrammingItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProgrammingItem,
            newItem: ProgrammingItem
        ): Boolean {
            return oldItem == newItem
        }

    }
}