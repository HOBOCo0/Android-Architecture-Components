package com.example.jetpackarcitecturecomponetspractice.viewModel
import androidx.lifecycle.ViewModel

class MainViewModel(val initialValues: Int): ViewModel() {
    var count:Int = initialValues

    fun increment(){
        count++
    }
}