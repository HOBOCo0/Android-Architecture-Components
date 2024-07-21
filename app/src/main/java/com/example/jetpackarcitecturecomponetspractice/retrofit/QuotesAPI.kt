package com.example.jetpackarcitecturecomponetspractice.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesAPI {

    @GET("/quotes")
    suspend fun getQuotes(@Query("limit") limit : Int, @Query("skip") skip:Int): Response<QuoteList>
}