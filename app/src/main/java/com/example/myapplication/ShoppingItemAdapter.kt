package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ShoppingItem
import com.example.myapplication.Package

class ShoppingItemAdapter(var shoppingItems: List<ShoppingItem>, var context: Context) : RecyclerView.Adapter<ShoppingItemAdapter.MyViewHolder>() {
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.shoppingItem_title)
        val package_name: TextView = view.findViewById(R.id.shoppingItem_package_name)
        val detail_button: Button = view.findViewById(R.id.shoppingItem_detail_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return shoppingItems.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = shoppingItems[position].title
        holder.package_name.text = PackageRepository.packages[shoppingItems[position].package_id].name

        holder.detail_button.setOnClickListener {
//            val intent = Intent(context, shoppingItemDetail::class.java)
//            intent.putExtra("shoppingItemId", shoppingItems[position].id)
//            context.startActivity(intent)
        }

    }
}