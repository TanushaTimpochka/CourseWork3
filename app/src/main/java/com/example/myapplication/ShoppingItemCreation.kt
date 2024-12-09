package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ShoppingItemCreation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shopping_item_creation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val title: EditText = findViewById(R.id.editTextTitle)
        val numberPackage: EditText = findViewById(R.id.editTextNumberPackage)

        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonBack: Button = findViewById(R.id.buttonBack)

        buttonAdd.setOnClickListener {
            val title = title.text.toString()
            val numberPackage = numberPackage.text.toString()

            if (title.isNotEmpty() && numberPackage.isNotEmpty()) {
                val idPackage = numberPackage.toInt()
                val shoppingItem = ShoppingItem(0, title, idPackage)
                val repository = ShoppingItemRepository(this)
                repository.addShoppingItem(shoppingItem)
                finish()

            } else {
                Toast.makeText(this, "Пожалуйста заполните все необходимые поля", Toast.LENGTH_SHORT).show()
            }
        }

        buttonBack.setOnClickListener {
            finish()
        }

    }
}