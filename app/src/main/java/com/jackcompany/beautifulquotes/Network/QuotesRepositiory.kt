package com.jackcompany.beautifulquotes.Network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jackcompany.beautifulquotes.Model.Quotes

class QuotesRepositiory(private val apiInterface: MyApiInterface) {

    private val quotesLivedata = MutableLiveData<Quotes>()

    val quotes: LiveData<Quotes>
        get() = quotesLivedata


        suspend fun getQuotes(){

            val result = apiInterface.getQuets()
            if (result.body()!=null){
                quotesLivedata.postValue(result.body())

            }

        }

}