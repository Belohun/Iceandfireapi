package com.example.iceandfireapi.ui.home

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iceandfireapi.data.network.IceAndFireApiService
import com.example.iceandfireapi.data.network.response.ResponseAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ViewData: Fragment() {
    fun refreshdata(context: Context) {
        val apiServive =
            IceAndFireApiService()
        GlobalScope.launch(Dispatchers.Main) {
            val IceAndFireResponse = apiServive.getCharacter().await()

            recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            val adapter = ResponseAdapter(context, IceAndFireResponse)
            recyclerView.adapter = adapter
        }


    }


}
