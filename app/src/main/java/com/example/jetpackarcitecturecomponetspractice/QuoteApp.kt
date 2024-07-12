package com.example.jetpackarcitecturecomponetspractice

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackarcitecturecomponetspractice.databinding.ActivityQuoteAppBinding

class QuoteApp : AppCompatActivity() {

    private val binding:ActivityQuoteAppBinding by lazy {
        ActivityQuoteAppBinding.inflate(layoutInflater)
    }
     private lateinit var quoteViewModel:MainViewModelQuotes
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        quoteViewModel = ViewModelProvider(this,MainViewModelFactoryQuotes(application)).get(MainViewModelQuotes::class.java)

        setQuote(quoteViewModel.getQuote())

        binding.apply {
            nextButton.setOnClickListener {
                quoteViewModel.nextQuote()
                setQuote(quoteViewModel.getQuote())
            }
            previousButton.setOnClickListener {
                quoteViewModel.preQuote()
                setQuote(quoteViewModel.getQuote())
            }
            shareButton.setOnClickListener {
                var intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_TEXT,quoteViewModel.getQuote().text)
                startActivity(intent)
            }
        }
    }
    fun setQuote(quote:QuoteDataModel){
        binding.apply {
            quoteText.text = quote.text
            quoteAuthor.text = quote.author
        }
    }

 }