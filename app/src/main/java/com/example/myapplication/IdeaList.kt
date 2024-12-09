package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class IdeaList : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_idea_list, container, false)
        val ideaList: RecyclerView = view.findViewById(R.id.ideaList)
        val ideas = IdeaItemRepository.packages

        ideaList.layoutManager = LinearLayoutManager(requireContext())
        ideaList.adapter = IdeaItemAdapter(ideas, requireContext())


        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = ShoppingList()
    }
}