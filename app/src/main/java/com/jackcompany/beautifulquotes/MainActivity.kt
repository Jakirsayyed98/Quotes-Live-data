package com.jackcompany.beautifulquotes

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.jackcompany.beautifulquotes.Network.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var quotesRepositiory: QuotesRepositiory
    private lateinit var viewmodelLivedata: ViewmodelLivedata
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    //    directRetrofit()
        livedataViewmodel()


    }

    private fun livedataViewmodel() {
        val data= ApisData.retrofitdata().create(MyApiInterface::class.java)

        val repository = QuotesRepositiory(data)

        viewmodelLivedata = ViewModelProvider(this,QuotesViewmodelFactory(repository)).get(ViewmodelLivedata::class.java)

        viewmodelLivedata.quotes.observe(this,{
            it.forEach {
                Log.d("newddata",it.text)
            }
        })


    }

//    private fun directRetrofit() {
//                val data= ApisData.retrofitdata().create(MyApiInterface::class.java)
//
//        GlobalScope.launch {
//            val result = data.getQuets()
//
//            if (result.body()!=null){
//
//                result.body()!!.forEach {
//                    Log.d("NewDataset",it.text)
//                }
//
//
//            }else{
//                print("NewDatasetnull"+result.body())
//            }
//        }
//
//    }
}