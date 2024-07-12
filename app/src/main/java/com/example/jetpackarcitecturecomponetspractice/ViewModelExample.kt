package com.example.jetpackarcitecturecomponetspractice

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackarcitecturecomponetspractice.databinding.ActivityViewModelExampleBinding

class ViewModelExample : AppCompatActivity() {

    private val binding:ActivityViewModelExampleBinding by lazy {
        ActivityViewModelExampleBinding.inflate(layoutInflater)
    }
    lateinit var  myViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // instantiating our viewModel object (view models are life cycle aware components so we need to pass the owner and get the custom viewmodel class)
        myViewModel = ViewModelProvider(this,MainViewModelFactory(10)).get(MainViewModel::class.java)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // this will set the value for the first time
        binding.IncrementText.setText(myViewModel.count.toString())

        // this will change the value on click
        binding.button.setOnClickListener {
            myViewModel.increment()
            binding.IncrementText.setText(myViewModel.count.toString())
        }
    }
}