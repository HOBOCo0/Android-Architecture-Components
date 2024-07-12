package com.example.jetpackarcitecturecomponetspractice
import androidx.lifecycle.ViewModel

class MainViewModel(val initialValues: Int): ViewModel() {
    var count:Int = initialValues

    fun increment(){
        count++
    }
}