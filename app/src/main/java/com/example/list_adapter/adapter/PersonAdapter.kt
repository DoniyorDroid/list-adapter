package com.example.list_adapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.list_adapter.R
import com.example.list_adapter.databinding.ItemPersonBinding
import com.example.list_adapter.model.Person

class PersonAdapter(var onClick: OnClick) :
    ListAdapter<Person, PersonAdapter.MyViewHolder>(PersonDiffUtil()) {

    inner class MyViewHolder(var binding: ItemPersonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(person: Person, position: Int) {
            binding.name.text = person.name
            binding.number.text = person.number
            binding.root.setOnClickListener {
                onClick.onClickListener(person, position)
            }
        }
    }

    class PersonDiffUtil : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemPersonBinding.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(getItem(position), position)
    }

    interface OnClick {
        fun onClickListener(person: Person, position: Int)
    }

    override fun submitList(list: MutableList<Person>?) {
        super.submitList(list)
    }
}