package com.jackcompany.beautifulquotes.Network

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jackcompany.beautifulquotes.Model.Quotes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewmodelLivedata(val quotesRepository: QuotesRepositiory) : ViewModel() {

    init {

        viewModelScope.launch (Dispatchers.IO){
            quotesRepository.getQuotes()
        }

    }

    val quotes : LiveData<Quotes>
    get() = quotesRepository.quotes

}