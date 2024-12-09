package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ShoppingItem


class ShoppingList : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_shopping_list, container, false)
        val shoppingList: RecyclerView = view.findViewById(R.id.shoppingList)
        val buttonAdd: Button = view.findViewById(R.id.buttonAdd)

        val repository = ShoppingItemRepository(context as Context)
        val shoppingItems = repository.getAllShoppingItems()

        shoppingList.layoutManager = LinearLayoutManager(requireContext())
        shoppingList.adapter = ShoppingItemAdapter(shoppingItems, requireContext())

        buttonAdd.setOnClickListener {
            val intent = Intent(context, ShoppingItemCreation::class.java)
            startActivity(intent)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = ShoppingList()
    }
}