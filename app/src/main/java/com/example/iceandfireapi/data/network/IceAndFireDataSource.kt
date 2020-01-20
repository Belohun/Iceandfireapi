package com.example.iceandfireapi.data.network

import androidx.lifecycle.LiveData
import com.example.iceandfireapi.data.network.response.IceAndFireResponse

interface IceAndFireDataSource {
    val downloaddedCharacters : LiveData<IceAndFireResponse>
    suspend fun fetchCharacter(
       page: String,
       pageSize: String

    )
}