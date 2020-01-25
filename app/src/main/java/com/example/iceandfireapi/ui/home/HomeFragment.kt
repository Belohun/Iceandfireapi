package com.example.iceandfireapi.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iceandfireapi.data.network.IceAndFireApiService
import com.example.iceandfireapi.data.network.response.ResponseAdapter
import com.example.shopapi.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {




        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
       /* val textView: TextView = root.findViewById(R.id.name)
        val button:TextView = root.findViewById(R.id.btn_char)*/
        val recyclerView:RecyclerView = root.findViewById(R.id.recyclerView)
       /* homeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        homeViewModel.button.observe(this, Observer {
           button.text=it
        })*/





        val context: Context
        context = this.context!!
        var page: Int = 2
        var pageSize: Int = 10

        GlobalScope.launch(Dispatchers.Main) {
            try {

                val apiServive =
                    IceAndFireApiService()
                GlobalScope.launch(Dispatchers.Main) {
                    val IceAndFireResponse = apiServive.getCharacter(/*page.toString(),pageSize.toString()*/).await()
                    d("APIRESPONSE",IceAndFireResponse[1].toString())

                    if(IceAndFireResponse[0]== null){
                        Toast.makeText(context, "Error while trying to get data", Toast.LENGTH_LONG).show()
                    }else{
                        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                        val adapter = ResponseAdapter(context,IceAndFireResponse,page,pageSize )
                        recyclerView.adapter = adapter
                    }

                }

                /*fragment.recyclerView.layoutManager = LinearLayoutManager(application, RecyclerView.VERTICAL, false)
                val adapter = ResponseAdapter(application, IceAndFireResponse)
                fragment.recyclerView.adapter = adapter*/

            } catch (e: IOException) {
                /* d("Internet","Error while tring to reach api")*/
                Toast.makeText(context, "Error while trying to get data", Toast.LENGTH_LONG).show()
            }
        }
        return root



    }
}