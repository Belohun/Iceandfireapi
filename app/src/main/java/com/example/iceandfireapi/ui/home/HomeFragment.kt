package com.example.iceandfireapi.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iceandfireapi.data.network.IceAndFireApiService
import com.example.iceandfireapi.data.network.response.ResponseAdapter
import com.example.shopapi.R
import kotlinx.android.synthetic.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

class HomeFragment : Fragment(){

    private lateinit var homeViewModel: HomeViewModel
    private var navController: NavController?=null
    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context: Context
        context = this.context!!
        var page: Int = 1
        var pageSize: Int = 10
        navController= Navigation.findNavController(container!!)




        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
       /* val textView: TextView = root.findViewById(R.id.name)
        val button:TextView = root.findViewById(R.id.btn_char)*/
        val recyclerView:RecyclerView = root.findViewById(R.id.recyclerView)
        val buttonRefreash: Button = root.findViewById(R.id.changepageBtn)

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





        val spinnerPage: Spinner = root.findViewById(R.id.page)
        val adapterPage :ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(context,R.array.page,android.R.layout.simple_spinner_item)
        adapterPage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerPage.adapter=adapterPage

        spinnerPage.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
               page = position+1

            }
        }
        val spinnerPageSize: Spinner= root.findViewById(R.id.pageSize)
        val adapterPageSize :ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(context,R.array.pageSize,android.R.layout.simple_spinner_item)
        adapterPageSize.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinnerPageSize.adapter=adapterPageSize
        spinnerPageSize.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                pageSize = (position+1)*10
          /*      d("spinner",position.toString())*/




            }
        }
        buttonRefreash.setOnClickListener{
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
        }




        return root



    }
}

