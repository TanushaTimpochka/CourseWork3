package com.example.myapplication

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class AnaliseAdapter(var statList: List<AnaliseItem>, var context: Context) : RecyclerView.Adapter<AnaliseAdapter.MyViewHolder>() {
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val analise_title: TextView = view.findViewById(R.id.analise_title)
        val analise_description: TextView = view.findViewById(R.id.analise_description)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.analise_item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return statList.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.analise_title.text = statList[position].name
        holder.analise_description.text = statList[position].description

    }
}