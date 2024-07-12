package com.example.jetpackarcitecturecomponetspractice

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModelQuotes(val context: Context):ViewModel() {

    private var quoteList:Array<QuoteDataModel> = emptyArray()
    private var index = 0

    // now we initialise the quote list -> to initialise we need to read our Json File
    init {
        quoteList =  loadQuotesfromAssets()
    }

    private fun loadQuotesfromAssets(): Array<QuoteDataModel> {
    // to read the json file we need the application context and that we will get it from main activity

        val inputStream = context.assets.open("quotess.json")
        val size:Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json,Array<QuoteDataModel>::class.java)
    }

    fun getQuote() = quoteList[index]
    fun nextQuote() = quoteList[++index]

    fun preQuote() = quoteList[--index]
}