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

class IdeaItemAdapter(var ideasItems: List<IdeaItem>, var context: Context) : RecyclerView.Adapter<IdeaItemAdapter.MyViewHolder>() {
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val idea_name: TextView = view.findViewById(R.id.idea_name)
        val idea_description: TextView = view.findViewById(R.id.idea_description)
        val image: ImageView = view.findViewById(R.id.ideaImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.idea_item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ideasItems.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.idea_name.text = ideasItems[position].name
        holder.idea_description.text = ideasItems[position].description

        val imgFile = File("@drawable/default_image.png")
        val resID = context.resources.getIdentifier("@drawable/default_image", "drawable", null)

        val imgBitmap = BitmapFactory.decodeFile(imgFile.absolutePath)
        holder.image.setImageResource(resID)
    }
}