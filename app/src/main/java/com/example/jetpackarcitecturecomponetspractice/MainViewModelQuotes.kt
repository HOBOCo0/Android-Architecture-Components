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

    // this is how we take a json file and convert/parse it into user defined datatype to use it.
    private fun loadQuotesfromAssets(): Array<QuoteDataModel> {
    // to read the json file we need the application context and that we will get it from main activity

    // Opens the "quotess.json" file from the assets folder using the application context
        val inputStream = context.assets.open("quotess.json")
    //Returns the estimated number of bytes that can be read from the input stream, which in this case is the size of the file.
        val size:Int = inputStream.available()
    // Creates a byte array of the given size to hold the data from the file.
        val buffer = ByteArray(size)
        //Reads the data from the input stream into the buffer array.
        inputStream.read(buffer)
        //Closes the input stream to free up resources.
        inputStream.close()

    // Converts the byte array buffer to a string using UTF-8 encoding, which represents the JSON content as a string.
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()

        //Uses the Gson instance to parse the JSON string and convert it into an array of QuoteDataModel objects.
        //Specifies the type of array to convert the JSON into, in this case, an array of QuoteDataModel.
        return gson.fromJson(json,Array<QuoteDataModel>::class.java)
    }

    fun getQuote() = quoteList[index]
    fun nextQuote() = quoteList[++index]

    fun preQuote() = quoteList[--index]
}