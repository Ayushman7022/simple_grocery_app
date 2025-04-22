package com.example.shopping_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shopping_app.databinding.ActivityFruitsBinding

class FruitsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFruitsBinding
    private lateinit var adapter: FruitAdapter  // Changed to specific adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFruitsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "All Fruits"

        val fruitsList = listOf(
            FruitItem(R.drawable.apple, "Apple"),
            FruitItem(R.drawable.banana, "Banana"),
            FruitItem(R.drawable.orange, "Orange"),
            FruitItem(R.drawable.mango, "Mango"),
            FruitItem(R.drawable.strawberry, "Strawberry"),
            FruitItem(R.drawable.grapes, "Grapes")
        )

        adapter = FruitAdapter(fruitsList) { fruit ->
            // Handle item click (can open detail activity if needed)
        }

        binding.rvFruits.apply {
            layoutManager = GridLayoutManager(this@FruitsActivity, 2)
            adapter = this@FruitsActivity.adapter
            setHasFixedSize(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}