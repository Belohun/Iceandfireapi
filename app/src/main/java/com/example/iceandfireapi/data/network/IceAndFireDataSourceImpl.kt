package com.example.iceandfireapi.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.iceandfireapi.data.network.response.IceAndFireResponse
import com.example.iceandfireapi.internal.NoConnectivityException

class IceAndFireDataSourceImpl(private val iceAndFireApiService: IceAndFireApiService) :
    IceAndFireDataSource {
    private val _downloadedCharacters   = MutableLiveData<IceAndFireResponse>()
    override val downloaddedCharacters: LiveData<IceAndFireResponse>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override suspend fun fetchCharacter(page: String, pageSize: String) {
        try{
            val fetchedCharacter = iceAndFireApiService
                .getCharacter()
               /* .await()*/
             /*   _downloadedCharacters.postValue()*/
        }
        catch (e: NoConnectivityException){
            Log.e("Connectivity","No internet connection",e)}
    }
}