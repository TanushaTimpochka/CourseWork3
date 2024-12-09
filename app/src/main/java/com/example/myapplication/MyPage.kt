package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MyPage : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)
        loadFragment(ShoppingList())
        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)!!
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.shoppingList -> {
                    loadFragment(ShoppingList())
                    true
                }
                R.id.profile -> {
                    loadFragment(Profile())
                    true
                }
                R.id.ideas -> {
                    loadFragment(IdeaList())
                    true
                }


                else -> {false}
            }
        }
    }
    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout,fragment)
        transaction.commit()
    }

}