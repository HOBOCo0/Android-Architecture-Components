package com.example.jetpackarcitecturecomponetspractice.liveData

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackarcitecturecomponetspractice.databinding.ActivityLiveDataExampleBinding

class LiveDataExampleActivity : AppCompatActivity() {

    private val binding:ActivityLiveDataExampleBinding by lazy {
        ActivityLiveDataExampleBinding.inflate(layoutInflater)
    }

    private lateinit var myViewModel: LiveDataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        myViewModel = ViewModelProvider(this).get(LiveDataViewModel::class.java)

        // we need an observer for the live data which is observing the change in the data
        myViewModel.myliveData.observe(this) {
            // we have to create an observer, to observe the data change
            binding.textView2.text = it
        }

        binding.button3.setOnClickListener {
            myViewModel.updateMyLiveData()
        }
    }
}