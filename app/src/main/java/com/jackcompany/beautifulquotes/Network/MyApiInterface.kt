package com.jackcompany.beautifulquotes.Network

import com.jackcompany.beautifulquotes.Model.Quotes
import retrofit2.Response
import retrofit2.http.GET

interface MyApiInterface {

    @GET("quotes")
    suspend fun getQuets():Response<Quotes>


}