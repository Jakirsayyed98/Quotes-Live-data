package com.jackcompany.beautifulquotes.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApisData {

    val base_url = "https://type.fit/api/"

    fun retrofitdata() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}