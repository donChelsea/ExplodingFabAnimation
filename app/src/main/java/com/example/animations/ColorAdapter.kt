package com.example.animations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.animations.databinding.ListItemColorsBinding

class ColorAdapter(private val colors: List<Int>): Adapter<ColorAdapter.ColorViewHolder>() {

    inner class ColorViewHolder(private val binding: ListItemColorsBinding): ViewHolder(binding.root) {
        fun bind(color: Int) = binding.itemLayout.setBackgroundColor(color)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val view = ListItemColorsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ColorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.bind(colors[position])
    }

    override fun getItemCount() = colors.size
}