package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Profile : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val username = view.findViewById<TextView>(R.id.username)

        val analiseList = view.findViewById<RecyclerView>(R.id.analise)
        val analiseSaveList = view.findViewById<RecyclerView>(R.id.analiseSave)

        val analise = ArrayList<AnaliseItem>()
        val analiseSave = ArrayList<AnaliseItem>()

        val repository = ShoppingItemRepository(context as Context)
        val shoppingItems = repository.getAllShoppingItems()
        val packageIdCounts: Map<Int, Int> = shoppingItems
            .groupingBy { it.package_id }
            .eachCount()

        for ((packageId, count) in packageIdCounts) {
            val packageItem = PackageRepository.packages[packageId]
            if (packageItem.save) {
                analiseSave.add(AnaliseItem(packageItem.name, "${count}шт."))
            }
            else {
                analise.add(AnaliseItem(packageItem.name, "${count}шт."))
            }
        }


        analiseList.layoutManager = LinearLayoutManager(requireContext())
        analiseList.adapter = AnaliseAdapter(analise, requireContext())

        analiseSaveList.layoutManager = LinearLayoutManager(requireContext())
        analiseSaveList.adapter = AnaliseAdapter(analiseSave, requireContext())

        username.text = "Татьяна"

        val buttonLogout = view.findViewById<Button>(R.id.buttonLogout)
        buttonLogout.setOnClickListener {
            val intent = Intent(context, Login::class.java)
            startActivity(intent)
        }

        return view
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Profile()
    }
}