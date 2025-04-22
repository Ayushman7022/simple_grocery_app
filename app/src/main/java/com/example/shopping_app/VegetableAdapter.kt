package com.example.shopping_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping_app.databinding.ItemVegetableBinding

class VegetableAdapter(
    private val vegetables: List<VegetableItem>,
    private val onItemClick: (VegetableItem) -> Unit
) : RecyclerView.Adapter<VegetableAdapter.VegetableViewHolder>() {

    inner class VegetableViewHolder(private val binding: ItemVegetableBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(vegetable: VegetableItem) {
            binding.ivVegetable.setImageResource(vegetable.imageRes)
            binding.tvVegetableName.text = vegetable.name
            binding.root.setOnClickListener { onItemClick(vegetable) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VegetableViewHolder {
        val binding = ItemVegetableBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return VegetableViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VegetableViewHolder, position: Int) {
        holder.bind(vegetables[position])
    }

    override fun getItemCount() = vegetables.size
}