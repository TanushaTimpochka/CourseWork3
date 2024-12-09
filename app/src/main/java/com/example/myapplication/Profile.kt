package com.example.myapplication

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
        val analise = ArrayList<AnaliseItem>()

        analise.add(AnaliseItem("Пластиковая бутылка", "1шт."))
        analise.add(AnaliseItem("Тэтрапак", "1шт."))
        analise.add(AnaliseItem("Целофановый пакт", "1шт."))
        analise.add(AnaliseItem("Пластиковая форма", "1шт."))


        analiseList.layoutManager = LinearLayoutManager(requireContext())
        analiseList.adapter = AnaliseAdapter(analise, requireContext())



        username.text = "Татьяна"
        return view
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Profile()
    }
}