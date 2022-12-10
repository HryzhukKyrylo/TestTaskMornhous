package com.example.testtaskmornhouse.ui.mainscreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskmornhouse.databinding.ItemNumberBinding
import com.example.testtaskmornhouse.domain.model.NumberModel

class MainAdapter : ListAdapter<NumberModel, MainViewHolder>(NumberDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemNumberBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MainViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = currentList[position]
        holder.bind(item = item)
    }

}

class MainViewHolder(private val binding: ItemNumberBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(
        item: NumberModel,
    ) {
        binding.tvNumber.text = item.number
        binding.tvInfoNumber.text = item.text
    }
}

