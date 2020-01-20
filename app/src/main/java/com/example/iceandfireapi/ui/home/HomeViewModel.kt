package com.example.iceandfireapi.ui.home
import kotlinx.coroutines.GlobalScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.iceandfireapi.data.network.IceAndFireApiService
import com.example.iceandfireapi.data.network.response.IceAndFireResponseList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {

        val apiServive =
            IceAndFireApiService()
        GlobalScope.launch(Dispatchers.Main) {val IceAndFireResponse = apiServive.getCharacter().await()
            value = IceAndFireResponse.name
            /*value = "This is shopping Fragment"*/
        }



    }
    private val _button = MutableLiveData<String>().apply {
    value = "Add"
    }

    val text: LiveData<String> = _text
    val button: LiveData<String> = _button
}


