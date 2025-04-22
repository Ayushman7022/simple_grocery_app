package com.example.shopping_app

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupBestSellerRecyclerView(view)
        setupNewArrivalsRecyclerView(view)
    }

    private fun setupBestSellerRecyclerView(view: View) {
        val bestSellerRecyclerView = view.findViewById<RecyclerView>(R.id.rvbestseller)
        val bestSellerList = listOf(
            CategoryItem(R.drawable.apple, "Fruits", "fruits"),
            CategoryItem(R.drawable.carrot, "Vegetables", "vegetables"),
            CategoryItem(R.drawable.milk, "Dairy", "dairy"),
            CategoryItem(R.drawable.grains, "Grains", "grains")
        )

        bestSellerRecyclerView.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = CategoryAdapter(bestSellerList) { clickedItem ->
                openCategoryList(clickedItem)
            }
            setHasFixedSize(true)
        }
    }

    private fun setupNewArrivalsRecyclerView(view: View) {
        val newArrivalsRecyclerView = view.findViewById<RecyclerView>(R.id.rvNewArrivals)
        val newArrivalsList = listOf(
            CategoryItem(R.drawable.strawberry, "Strawberry", "fruits"),

        )

        newArrivalsRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2) // 2-column grid
            adapter = CategoryAdapter(newArrivalsList) { clickedItem ->
                // Open the appropriate category activity
                openCategoryList(clickedItem)
            }
            setHasFixedSize(true)
        }
    }

    private fun openCategoryList(item: CategoryItem) {
        val intent = when (item.categoryType) {
            "fruits" -> Intent(requireContext(), FruitsActivity::class.java)
            "vegetables" -> Intent(requireContext(), VegetablesActivity::class.java)


            else -> Intent(requireContext(), Vegis::class.java)
        }.apply {
            // Pass any relevant data to the activity
            putExtra("CATEGORY_NAME", item.title)
        }
        startActivity(intent)
    }
}