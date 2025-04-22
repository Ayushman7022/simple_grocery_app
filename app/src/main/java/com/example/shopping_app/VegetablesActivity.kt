package com.example.shopping_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shopping_app.databinding.ActivityVegetablesBinding

class VegetablesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVegetablesBinding
    private lateinit var adapter: VegetableAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVegetablesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "All Vegetables"

        val vegetablesList = listOf(
            VegetableItem(R.drawable.carrot, "Carrot"),
            VegetableItem(R.drawable.tomato, "Tomato"),
            VegetableItem(R.drawable.broccoli, "Broccoli"),
            VegetableItem(R.drawable.potato, "Potato"),
            VegetableItem(R.drawable.onion, "Onion"),
            VegetableItem(R.drawable.cucumber, "Cucumber")
        )

        adapter = VegetableAdapter(vegetablesList) { vegetable ->
            // Handle item click
        }

        binding.rvVegetables.apply {
            layoutManager = GridLayoutManager(this@VegetablesActivity, 2)
            adapter = this@VegetablesActivity.adapter
            setHasFixedSize(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}