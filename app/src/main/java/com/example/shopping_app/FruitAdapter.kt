package com.example.shopping_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping_app.databinding.ItemFruitBinding

class FruitAdapter(
    private val fruits: List<FruitItem>,
    private val onItemClick: (FruitItem) -> Unit
) : RecyclerView.Adapter<FruitAdapter.FruitViewHolder>() {

    inner class FruitViewHolder(private val binding: ItemFruitBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(fruit: FruitItem) {
            binding.ivFruit.setImageResource(fruit.imageRes)
            binding.tvFruitName.text = fruit.name
            binding.root.setOnClickListener { onItemClick(fruit) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val binding = ItemFruitBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FruitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        holder.bind(fruits[position])
    }

    override fun getItemCount() = fruits.size
}