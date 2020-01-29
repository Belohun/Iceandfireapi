package com.example.iceandfireapi.data.network

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iceandfireapi.data.network.response.IceAndFireResponse
import com.example.iceandfireapi.data.network.response.ResponseAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

object IceAndFireList: ArrayList<IceAndFireResponse>() {
    fun getdata(context: Context){
        val apiServive =
            IceAndFireApiService()

        GlobalScope.launch(Dispatchers.Main) {
            try {

                val iceAndFireResponse: ArrayList<IceAndFireResponse> =apiServive.getCharacter().await()
                IceAndFireList.addAll(iceAndFireResponse)
                Log.d("APIRESPONSE", IceAndFireList[1].toString())
                if(IceAndFireList[0]== null){
                    Toast.makeText(context, "Error while trying to get data", Toast.LENGTH_LONG).show()
                }else{

                }

                /*fragment.recyclerView.layoutManager = LinearLayoutManager(application, RecyclerView.VERTICAL, false)
                val adapter = ResponseAdapter(application, IceAndFireResponse)
                fragment.recyclerView.adapter = adapter*/

            } catch (e: IOException) {
                /* d("Internet","Error while tring to reach api")*/
                Toast.makeText(context, "Error while trying to get data", Toast.LENGTH_LONG).show()
            }
        }
    }


}