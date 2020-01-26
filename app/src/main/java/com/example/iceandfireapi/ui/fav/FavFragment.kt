package com.example.iceandfireapi.ui.fav

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iceandfireapi.data.network.IceAndFireApiService
import com.example.iceandfireapi.data.network.response.FavAdapter
import com.example.iceandfireapi.data.network.response.ResponseAdapter
import com.example.iceandfireapi.ui.home.HomeViewModel
import com.example.shopapi.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

class FavFragment : Fragment() {

    private lateinit var favViewModel: FavViewModel
    private var navController: NavController?=null
    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context: Context
        context = this.context!!
        navController= Navigation.findNavController(container!!)




        favViewModel =
            ViewModelProviders.of(this).get(FavViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_fav, container, false)
        /* val textView: TextView = root.findViewById(R.id.name)
         val button:TextView = root.findViewById(R.id.btn_char)*/
        val recyclerView: RecyclerView = root.findViewById(R.id.recyclerView)

        /* homeViewModel.text.observe(this, Observer {

             textView.text = it
         })
         homeViewModel.button.observe(this, Observer {
            button.text=it
         })*/
        GlobalScope.launch(Dispatchers.Main) {
            try {

                val apiServive =
                    IceAndFireApiService()
                GlobalScope.launch(Dispatchers.Main) {
                    val IceAndFireResponse = apiServive.getCharacter(/*page.toString(),pageSize.toString()*/).await()
                    Log.d("APIRESPONSE", IceAndFireResponse[1].toString())

                    if(IceAndFireResponse[0]== null){
                        Toast.makeText(context, "Error while trying to get data", Toast.LENGTH_LONG).show()
                    }else{
                        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                        val adapter = FavAdapter(context,IceAndFireResponse)
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

