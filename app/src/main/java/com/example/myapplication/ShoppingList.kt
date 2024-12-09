package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        val vacancies = ArrayList<ShoppingItem>()

        vacancies.add(ShoppingItem(1, "Мясо", 6))
        vacancies.add(ShoppingItem(2, "Овощи на развес", 1))
        vacancies.add(ShoppingItem(3, "Вода 1.5 литра", 2))
        vacancies.add(ShoppingItem(4, "Сок 1 литр", 3))


        shoppingList.layoutManager = LinearLayoutManager(requireContext())
        shoppingList.adapter = ShoppingItemAdapter(vacancies, requireContext())


        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = ShoppingList()
    }
}