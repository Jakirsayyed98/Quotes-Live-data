package com.jackcompany.beautifulquotes.Network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class QuotesViewmodelFactory(private val quotesRepositiory: QuotesRepositiory):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewmodelLivedata(quotesRepositiory)  as T
    }


}