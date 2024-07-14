package com.example.jetpackarcitecturecomponetspractice.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// whatever data will be there we will pass it to this MainViewModelFactory and this will create
// object for us
class MainViewModelFactory(val counter:Int):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(counter) as T
    }
}
/*
SUMMARY:-

 -> whenever we want pass data in our viewModel then we need to use ViewModelFactoryFactory concept
 ->  So what this factory will do, it will take the data and will create object for us .
 */