package com.example.shopping_app

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
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // New Arrivals RecyclerView
        val newArrivalsRecyclerView = view.findViewById<RecyclerView>(R.id.rvNewArrivals)

        val newArrivalsList = listOf(
            CategoryItem(R.drawable.img, "Fruits"),
            CategoryItem(R.drawable.img, "Vegetables"),
            CategoryItem(R.drawable.img, "Dairy"),
            CategoryItem(R.drawable.img, "Beverages"),
            CategoryItem(R.drawable.img, "Snacks"),
            CategoryItem(R.drawable.img, "Bakery"),
            CategoryItem(R.drawable.img, "Cereals"),
            CategoryItem(R.drawable.img, "Spices"),
            CategoryItem(R.drawable.img, "Snacks"),
            CategoryItem(R.drawable.img, "Bakery"),
            CategoryItem(R.drawable.img, "Cereals"),
            CategoryItem(R.drawable.img, "Spices"),
            CategoryItem(R.drawable.img, "Snacks"),
            CategoryItem(R.drawable.img, "Bakery"),
            CategoryItem(R.drawable.img, "Cereals"),
            CategoryItem(R.drawable.img, "Spices"),
            CategoryItem(R.drawable.img, "Snacks"),
            CategoryItem(R.drawable.img, "Bakery"),
            CategoryItem(R.drawable.img, "Cereals"),
            CategoryItem(R.drawable.img, "Spices"),
            CategoryItem(R.drawable.img, "Snacks"),
            CategoryItem(R.drawable.img, "Bakery"),
            CategoryItem(R.drawable.img, "Cereals"),
            CategoryItem(R.drawable.img, "Spices")
        )

        newArrivalsRecyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        newArrivalsRecyclerView.adapter = CategoryAdapter(newArrivalsList)

        // Best Seller RecyclerView
        val bestSellerRecyclerView = view.findViewById<RecyclerView>(R.id.rvbestseller)

        val bestSellerList = listOf(
            CategoryItem(R.drawable.img, "Apple"),
            CategoryItem(R.drawable.img, "Milk"),
            CategoryItem(R.drawable.img, "Cold Drink"),
            CategoryItem(R.drawable.img, "Chips")
        )

        bestSellerRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        bestSellerRecyclerView.adapter = CategoryAdapter(bestSellerList)
    }
}
