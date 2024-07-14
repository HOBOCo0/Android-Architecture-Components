package com.example.jetpackarcitecturecomponetspractice.databinding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.jetpackarcitecturecomponetspractice.R

class MainActivityBind : AppCompatActivity() {
    private lateinit var binding:ActivityMainBindBinding
    private lateinit var myViewModelBind : MainViewModelBind
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // create binding object to set layout
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main_bind)

        // creating object of ViewModel
        myViewModelBind = ViewModelProvider(this).get(MainViewModelBind::class.java)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // create data class object to set the values in the view
        var quoteeObj = Quotee("I am a sequence of Character","String" )
        binding.quote = quoteeObj

//        // setting observer for the live data by passing owner to it
//        myViewModelBind.quoteLiveData.observe(this) {
//            binding.quoteTextText.text = it
//        }

        // assigning the actual object to layout variable
        binding.mainViewModel = myViewModelBind
        // if you are using liveData in binding you have to set its life cycle owner
        binding.lifecycleOwner = this
    }
}