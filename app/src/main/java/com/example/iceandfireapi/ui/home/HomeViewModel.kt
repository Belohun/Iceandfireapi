package com.example.iceandfireapi.ui.home
import android.app.Application
import android.content.Context
import android.util.Log.d
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.GlobalScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iceandfireapi.data.network.IceAndFireApiService
import com.example.iceandfireapi.data.network.response.ResponseAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class HomeViewModel(application: Application) : AndroidViewModel(application) {

        private val _text = MutableLiveData<String>().apply {


        val apiServive =
            IceAndFireApiService()
                var page: Int = 1
                var pageSize: Int = 20

            val context: Context


/*
                GlobalScope.launch(Dispatchers.Main) {
                    try {
                    val IceAndFireResponse = apiServive.getCharacter(page.toString(),pageSize.toString()).await()
                        value = IceAndFireResponse[1].name
                     */
/*   ViewData().refreshdata(application,IceAndFireResponse)

                        fragment.recyclerView.layoutManager = LinearLayoutManager(application, RecyclerView.VERTICAL, false)
                        val adapter = ResponseAdapter(application, IceAndFireResponse)
                        fragment.recyclerView.adapter = adapter
*//*

                }catch(e: IOException){
                        d("Internet","Error while tring to reach api")
                         Toast.makeText(application,"Error while trying to get data",Toast.LENGTH_LONG).show()
                    }



        }
*/
           /* value = IceAndFireData().List[1].name*/



    }

    private val _button = MutableLiveData<String>().apply {
        value = "Add"
    }


    val text: LiveData<String> = _text
    val button: LiveData<String> = _button



}


