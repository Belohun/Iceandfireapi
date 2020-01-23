package com.example.iceandfireapi.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import org.w3c.dom.CharacterData

@Dao
interface ICharacter {
    @Insert
    suspend fun ins(c: DataModel)
    @Delete
    suspend fun del(c: DataModel)
    @Query("Select * from favourite_characters")
    suspend fun getAllCharacters(): List<DataModel>
    @Query("Select * from favourite_characters where name==:name")
    suspend fun getCharacterByName(name: String): DataModel
    @Query("Select * from favourite_characters where played_by like '%' || :actor || '%'")
    suspend fun getCharacterByActor(actor: String): DataModel

}