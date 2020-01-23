package com.example.iceandfireapi.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import org.w3c.dom.CharacterData

@Dao
interface ICharacter {
    @Insert
    fun ins(c: DataModel)
    @Delete
    fun del(c: DataModel)
    @Query("Select * from favourite_characters")
    fun getAllCharacters(): List<DataModel>
    @Query("Select * from favourite_characters where name==:name")
    fun getCharacterByName(name: String): DataModel
    @Query("Select * from favourite_characters where played_by like '%' || :actor || '%'")
    fun getCharacterByActor(actor: String): DataModel

}