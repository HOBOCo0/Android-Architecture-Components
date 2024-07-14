package com.example.jetpackarcitecturecomponetspractice.quoteApp

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactoryQuotes(private val context : Context):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModelQuotes(context) as T
    }
}
