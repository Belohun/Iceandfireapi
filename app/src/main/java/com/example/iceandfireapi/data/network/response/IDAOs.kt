package com.example.iceandfireapi.data.network.response

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface IDAOs {
    @Insert
    suspend fun addCharacter(character: IceAndFireResponse)

    @Query("SELECT * FROM characters")
    suspend fun allCharacters(): List<IceAndFireResponse>

    @Query("SELECT * FROM characters WHERE name=:name")
    suspend fun selectByName(name: String): IceAndFireResponse

    @Delete
    suspend fun delete(character: IceAndFireResponse)


}