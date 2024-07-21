package com.example.jetpackarcitecturecomponetspractice.retrofit

data class QuoteList(
    val limit: Int,
    val quotes: List<Quote>,
    val skip: Int,
    val total: Int
)