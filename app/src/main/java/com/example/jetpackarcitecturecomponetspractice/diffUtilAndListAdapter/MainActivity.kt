package com.example.jetpackarcitecturecomponetspractice.diffUtilAndListAdapter

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackarcitecturecomponetspractice.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)
        val adapter = ProgrammingAdapter()

        val p1 = ProgrammingItem(1,"J", "Java")
        val p2 = ProgrammingItem(1,"K", "Kotlin")
        val p3 = ProgrammingItem(1,"A", "Android")

        adapter.submitList(listOf(p1,p2,p3))
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val p4 = ProgrammingItem(1,"J", "Java")
            adapter.submitList(listOf(p4))

        },5000)
        }
    }