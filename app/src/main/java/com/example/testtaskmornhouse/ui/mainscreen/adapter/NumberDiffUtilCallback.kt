package com.example.testtaskmornhouse.ui.mainscreen.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.testtaskmornhouse.domain.model.NumberModel

class NumberDiffUtilCallback : DiffUtil.ItemCallback<NumberModel>() {
    override fun areItemsTheSame(oldItem: NumberModel, newItem: NumberModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: NumberModel, newItem: NumberModel): Boolean {
        return oldItem == newItem
    }
}
